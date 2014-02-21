package com.example.jdance.app.model;


import java.io.Serializable;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

public class Robot implements Serializable {
    private int id;
    private Choreography choreography;

    public Robot(int id) {
        super();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Choreography getChorepgraphy() {
        return choreography;
    }

    public void setChorepgraphy(Choreography chorepgraphy) {
        this.choreography = chorepgraphy;
    }


    /**
     * @return JsonObjectBuilder looks like
     * <p/>
     * {
     * "target": "board",
     * "board": {"device": "/dev/ttyUSB0"},
     * "command": "__init__"
     * "id": "1"
     * }
     * <p/>
     * <p/>
     * initializes the Robot
     */

    private JsonObjectBuilder jsonInitRobot(String device) {
        return Json.createObjectBuilder()
                .add("target", "robot")
                .add("board", Json.createObjectBuilder()
                        .add("device", device))
                .add("command", "__init__")
                .add("id", id);
    }

    /**
     * @param device           to send the step for example /dev/ttyUSB0
     * @param jsonArrayBuilder main json array looks like [] when empty
     *                         <p/>
     *                         put json steps in this jsonArrayBuilder
     */

    public void toJson(String device, JsonArrayBuilder jsonArrayBuilder) {
        jsonArrayBuilder.add(jsonInitRobot(device));
        choreography.toJson(id, device, jsonArrayBuilder);
    }

    public int countSteps() {
        return this.choreography.getSteps().size();
    }

    public int countSeconds() {
        return this.choreography.countSeconds();
    }

    public boolean equals(Object o) {
        Robot otherRobot = (Robot) o;
        return this.getId() == otherRobot.getId();
    }

    public String toString() {
        return "Robot" + id;
    }

}
