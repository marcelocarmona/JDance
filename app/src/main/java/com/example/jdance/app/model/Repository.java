package com.example.jdance.app.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mclo on 11/12/13.
 * <p/>
 * Singleton que contiene todos los objetos de la aplicación
 */
public class Repository {

    private List<Robot> robots;
    private List<Step> steps;
    private List<Choreography> choreographies;
    private List<Robot> danceFloor;

    //contiene valores por defecto para probar en la aplicacion
    private static Repository ourInstance = new Repository(
            new ArrayList<Robot>(
                    Arrays.asList(
                            new Robot(1),
                            new Robot(2),
                            new Robot(3),
                            new Robot(4),
                            new Robot(5),
                            new Robot(6),
                            new Robot(7),
                            new Robot(8),
                            new Robot(9),
                            new Robot(10),
                            new Robot(11),
                            new Robot(12),
                            new Robot(13),
                            new Robot(14),
                            new Robot(15),
                            new Robot(16),
                            new Robot(17),
                            new Robot(18),
                            new Robot(19),
                            new Robot(20))
            ),
            new ArrayList<Step>(
                    Arrays.asList(new DefaultStep("forward", 50, 50, 3),
                            new DefaultStep("turn", 50, 0, 3))
            ),
            new ArrayList<Choreography>(
                    Arrays.asList(
                            new Choreography("coreo1", new ArrayList<Step>(
                                    Arrays.asList(
                                            new DefaultStep("step1", 30, 30, 3),
                                            new DefaultStep("step2", 30, 0, 3),
                                            new DefaultStep("step3", 30, 30, 3)))))
            ),
            new ArrayList<Robot>());

    public static Repository getInstance() {
        return ourInstance;
    }

    private Repository(List<Robot> robots, List<Step> steps, List<Choreography> choreographies, List<Robot> danceFloor) {
        this.robots = robots;
        this.steps = steps;
        this.choreographies = choreographies;
        this.danceFloor = danceFloor;
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public void setRobots(List<Robot> robots) {
        this.robots = robots;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public List<Choreography> getChoreographies() {
        return choreographies;
    }

    public void setChoreographies(List<Choreography> choreographies) {
        this.choreographies = choreographies;
    }

    public List<Robot> getDanceFloor() {
        return danceFloor;
    }

    public void setDanceFloor(List<Robot> danceFloor) {
        this.danceFloor = danceFloor;
    }
}
