package com.example.jdance.app.model;

import javax.json.Json;
import javax.json.JsonArrayBuilder;

/**
 * Created by mclo on 24/02/14.
 */
public class BeepStep implements Step {

    private int beep;
    private double secondsDuration;

    public BeepStep(int beep, double secondsDuration) {
        this.beep = beep;
        this.secondsDuration = secondsDuration;
    }

    @Override
    public void toJson(int robotId, String device, JsonArrayBuilder jsonArrayBuilder) {
        jsonArrayBuilder.add(Json.createObjectBuilder()
                .add("target", "robot")
                .add("board", Json.createObjectBuilder()
                        .add("device", device))
                .add("id", robotId)
                .add("command", "beep")
                .add("args", Json.createArrayBuilder()
                        .add(beep)
                        .add(secondsDuration)));
    }

    @Override
    public double getSecondsDuration() {
        return secondsDuration;
    }

    @Override
    public String toString() {
        return "Beep(" + beep + ", " + secondsDuration + ")";
    }
}
