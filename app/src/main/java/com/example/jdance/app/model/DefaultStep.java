package com.example.jdance.app.model;

import java.io.Serializable;

import javax.json.Json;
import javax.json.JsonArrayBuilder;

public class DefaultStep implements Step, Serializable {

    private String name;
    private int leftMotorVelocity;
    private int rightMotorVelocity;
    private int secondsDuration;

    public DefaultStep(String name, int leftMotorVelocity, int rightMotorVelocity,
                       int secondsDuration) {
        this.name = name;
        this.leftMotorVelocity = leftMotorVelocity;
        this.rightMotorVelocity = rightMotorVelocity;
        this.secondsDuration = secondsDuration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeftMotorVelocity() {
        return leftMotorVelocity;
    }

    public void setLeftMotorVelocity(int leftMotorVelocity) {
        this.leftMotorVelocity = leftMotorVelocity;
    }

    public int getRightMotorVelocity() {
        return rightMotorVelocity;
    }

    public void setRightMotorVelocity(int rightMotorVelocity) {
        this.rightMotorVelocity = rightMotorVelocity;
    }

    public int getSecondsDuration() {
        return secondsDuration;
    }

    public void setSecondsDuration(int secondsDuration) {
        this.secondsDuration = secondsDuration;
    }

    /* (non-Javadoc)
     * @see model.Step#toJson(int, java.lang.String, javax.json.JsonArrayBuilder)
     */
    public void toJson(int robotId, String device, JsonArrayBuilder jsonArrayBuilder) {
        jsonArrayBuilder.add(Json.createObjectBuilder()
                .add("target", "robot")
                .add("board", Json.createObjectBuilder()
                        .add("device", device))
                .add("id", robotId)
                .add("command", "motors")
                .add("args", Json.createArrayBuilder()
                        .add(rightMotorVelocity)
                        .add(leftMotorVelocity)
                        .add(secondsDuration)));
    }


    public String toString() {
        return getName() + " (" + leftMotorVelocity + ", " + rightMotorVelocity + ", " + secondsDuration + ")";
    }

}

