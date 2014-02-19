package com.example.jdance.app.model;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.json.JsonArray;


/**
 * Created by mclo on 18/02/14.
 */
public class SenderRequestTask extends AsyncTask<JsonArray, String, String> {

    private String ip;
    private String port;

    public SenderRequestTask(String ip, String port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    protected String doInBackground(JsonArray... jsonArrays) {
        String json = null;
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost request = new HttpPost("http://" + ip + ":" + port);
        request.addHeader("Content-Type", "application/x-www-form-urlencoded");
        try {
            request.setEntity(new StringEntity("commands=" + jsonArrays[0]));
            HttpResponse response = httpclient.execute(request);

            json = new BufferedReader(new InputStreamReader(response
                    .getEntity().getContent())).readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}
