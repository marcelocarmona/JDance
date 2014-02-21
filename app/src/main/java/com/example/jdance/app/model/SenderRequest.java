package com.example.jdance.app.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;


/**
 * @author mclo
 *         <p/>
 *         clase encargada de enviar los requerimientos al servidor
 */
public class SenderRequest {

    String ip;
    String port;
    String device;

    public SenderRequest(Context context) {

        //get preferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        this.ip = prefs.getString("ip", "127.0.0.1");
        this.port = prefs.getString("port", "8000");
        this.device = prefs.getString("device", "/dev/ttyUSB0");
    }

    /**
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws java.lang.reflect.InvocationTargetException
     * @throws org.apache.http.client.ClientProtocolException
     * @throws java.io.IOException                            Metodo encargado de enviar los requerimientos al servidor segun lo pedido en la entrega
     */
    public void toDance() {

        //get robots
        List<Robot> robots = Repository.getInstance().getDanceFloor();

        for (Robot robot : robots) {
            //build json
            JsonArrayBuilder jsonMainArray = jsonMainArray(device);
            robot.toJson(device, jsonMainArray);
            JsonArray jsonArray = jsonMainArray.build();

            //send request
            SenderRequestTask senderRequestTask = new SenderRequestTask(ip, port);
            senderRequestTask.execute(jsonArray);
        }
        //clear dance floor
        robots.clear();
    }

    /**
     * @throws java.io.IOException Carga los robots del servidor en Repository
     */
    public void loadRobots() throws IOException {

        //clear robots
        List<Robot> robots = Repository.getInstance().getRobots();
        robots.clear();

        //build json
        JsonArray jsonArray = jsonMainArray(device).add(jsonBoardReport(device)).build();

        //send request
        SenderRequestTask senderRequestTask = new SenderRequestTask(ip, port);
        senderRequestTask.execute(jsonArray);
        String json = null;
        try {
            json = senderRequestTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if (json == null) throw new IOException();

        //parse request
        JsonParser parser = Json.createParser(new StringReader(json));
        while (parser.hasNext()) {
            JsonParser.Event event = parser.next();
            if (event == Event.VALUE_NUMBER) {
                int robotId = Integer.parseInt(parser.getString());
                Robot robot = new Robot(robotId);
                robots.add(robot);
            }
        }
    }


    /**
     * @return how many robots are connected
     * <p/>
     * looks like
     * <p/>
     * {
     * "target": "board",
     * "board": {"device": "/dev/ttyUSB0"},
     * "command": "report"
     * }
     */
    private JsonObjectBuilder jsonBoardReport(String device) {
        return Json.createObjectBuilder()
                .add("target", "board")
                .add("board", Json.createObjectBuilder()
                        .add("device", device))
                .add("command", "report");
    }


    /**
     * @return JsonObjectBuilder looks like
     * <p/>
     * {
     * "target": "board",
     * "board": {"device": "/dev/ttyUSB0"},
     * "command": "__init__"
     * }
     * <p/>
     * <p/>
     * initializes the board
     */
    private JsonObjectBuilder jsonInitBoard(String device) {
        return Json.createObjectBuilder()
                .add("target", "board")
                .add("board", Json.createObjectBuilder()
                        .add("device", device))
                .add("command", "__init__");
    }


    /**
     * @return JsonArrayBuilder contain all json to send the server
     * <p/>
     * looks like
     * <p/>
     * [
     * {
     * "target": "board",
     * "board": {"device": "/dev/ttyUSB0"},
     * "command": "__init__"
     * },
     * {
     * "target": "robot",
     * "board": {"device": "/dev/ttyUSB0"},
     * "command": "__init__",
     * "id": 1
     * },
     * {
     * "target": "robot",
     * "board": {"device": "/dev/ttyUSB0"},
     * "id": 1,
     * "command": "forward",
     * "args": [50, 2]
     * },
     * {
     * "target": "robot",
     * "board": {"device": "/dev/ttyUSB0"},
     * "id": 1,
     * "command": "turnLeft",
     * "args": [50, 2]
     * }
     * ]
     */
    private JsonArrayBuilder jsonMainArray(String device) {
        return Json.createArrayBuilder()
                .add(jsonInitBoard(device));
    }
}
