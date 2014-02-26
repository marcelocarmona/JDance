package com.example.jdance.app.model;

import java.io.Serializable;
import java.util.List;

import javax.json.JsonArrayBuilder;

public class Choreography implements Serializable {
    private String name;
    private List<Step> steps;


    public Choreography(String name, List<Step> steps) {
        super();
        this.name = name;
        this.steps = steps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public String toString() {
        return name;
    }

    /**
     * @param robotId          for example 0,1,2
     * @param device           to send the step for example /dev/ttyUSB0
     * @param jsonArrayBuilder main json array looks like [] when empty
     *                         <p/>
     *                         put json steps in this jsonArrayBuilder
     */
    public void toJson(int robotId, String device, JsonArrayBuilder jsonArrayBuilder) {
        for (Step step : steps) {
            step.toJson(robotId, device, jsonArrayBuilder);
        }
    }

    public double countSeconds() {
        double seconds = 0;
        for (Step step : steps) {
            seconds += step.getSecondsDuration();
        }
        return seconds;
    }

}
