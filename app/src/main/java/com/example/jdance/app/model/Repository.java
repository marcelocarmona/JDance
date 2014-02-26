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
                    Arrays.asList(
                            new DefaultStep("Forward", 50, 50, 2),
                            new DefaultStep("Backward", -50, -50, 2),
                            new DefaultStep("TurnLeft", 50, 0, 1),
                            new DefaultStep("TurnRight", 0, 50, 1),
                            new DefaultStep("RightSpin", -50, 50, 2),
                            new DefaultStep("LeftSpin", 50, -50, 2),
                            new DefaultStep("Wait", 0, 0, 3))
            ),
            new ArrayList<Choreography>(
                    Arrays.asList(
                            new Choreography("All Spins", new ArrayList<Step>(
                                    Arrays.asList(
                                            new DefaultStep("step1", -50, 50, 3),
                                            new DefaultStep("step2", 100, 0, 2),
                                            new DefaultStep("step3", 0, 100, 2),
                                            new DefaultStep("step4", 100, 0, 1),
                                            new DefaultStep("step5", 0, 100, 1),
                                            new DefaultStep("step6", 100, 0, 1),
                                            new DefaultStep("step7", 0, 100, 1),
                                            new DefaultStep("step8", 100, -100, 3)))),
                            new Choreography("Forward And Backward", new ArrayList<Step>(
                                    Arrays.asList(
                                            new DefaultStep("step1", 50, 50, 3),
                                            new DefaultStep("step2", -10, -10, 5),
                                            new DefaultStep("step3", 100, 100, 1),
                                            new DefaultStep("step4", -100, -100, 1),
                                            new DefaultStep("step5", 100, 100, 1),
                                            new DefaultStep("step6", -100, -100, 1),
                                            new DefaultStep("step7", 10, 10, 5),
                                            new DefaultStep("step8", -50, -50, 3)))),
                            new Choreography("Snake", new ArrayList<Step>(
                                    Arrays.asList(
                                            new DefaultStep("step1", 50, 0, 1),
                                            new DefaultStep("step2", 0, 50, 1),
                                            new DefaultStep("step3", 100, 0, 1),
                                            new DefaultStep("step4", 0, 100, 1),
                                            new DefaultStep("step5", 10, 0, 1),
                                            new DefaultStep("step6", 0, 10, 1),
                                            new DefaultStep("step7", -50, 0, 1),
                                            new DefaultStep("step8", 0, -50, 1),
                                            new DefaultStep("step9", -100, 0, 1),
                                            new DefaultStep("step10", 0, -100, 1),
                                            new DefaultStep("step11", -10, 0, 1),
                                            new DefaultStep("step12", 0, -10, 1),
                                            new DefaultStep("step13", 100, -100, 3)))),
                            new Choreography("Long Turns", new ArrayList<Step>(
                                    Arrays.asList(
                                            new DefaultStep("step1", 10, 100, 2),
                                            new DefaultStep("step2", 100, 10, 2),
                                            new DefaultStep("step3", -100, -10, 2),
                                            new DefaultStep("step4", -10, -100, 2),
                                            new DefaultStep("step5", 100, 10, 2),
                                            new DefaultStep("step6", 10, 100, 2),
                                            new DefaultStep("step7", -10, -100, 2),
                                            new DefaultStep("step8", -100, -10, 2),
                                            new DefaultStep("step9", -100, 100, 3),
                                            new DefaultStep("step10", 100, -100, 3)))),
                            new Choreography("Mario Life", new ArrayList<Step>(
                                    Arrays.asList(
                                            new DefaultStep("step1", 100, -100, 1),
                                            new BeepStep(330,0.1),
                                            new BeepStep(392,0.1),
                                            new BeepStep(659,0.1),
                                            new BeepStep(523,0.1),
                                            new BeepStep(587,0.1),
                                            new BeepStep(784,0.1),
                                            new DefaultStep("step1", -100, 100, 1)))),
                            new Choreography("Mario Theme", new ArrayList<Step>(
                                    Arrays.asList(
                                            new BeepStep(660,0.1),
                                            new DefaultStep("s1", 100, 0, 0.05),
                                            new BeepStep(660,0.1),
                                            new DefaultStep("s1", 100, 0, 0.05),
                                            new BeepStep(660,0.1),
                                            new DefaultStep("s1", 100, 0, 0.2),
                                            new BeepStep(510,0.1),
                                            new DefaultStep("s1", 100, 0, 0.05),
                                            new BeepStep(660,0.1),
                                            new DefaultStep("s1", 100, 0, 0.2),
                                            new BeepStep(770,0.1),
                                            new DefaultStep("s1", 100, 0, 0.45),
                                            new BeepStep(380,0.1),
                                            new DefaultStep("s1", -100, 0, 0.475),
                                            new BeepStep(510,0.1),
                                            new DefaultStep("s1", -100, 0, 0.35),
                                            new BeepStep(380,0.1),
                                            new DefaultStep("s1", -100, 0, 0.3),
                                            new BeepStep(320,0.1),
                                            new DefaultStep("s1", -100, 0, 0.4),
                                            new BeepStep(440,0.1),
                                            new DefaultStep("s1", -100, 0, 0.2),
                                            new BeepStep(480,0.08),
                                            new DefaultStep("s1", 0, 100, 0.23),
                                            new BeepStep(450,0.1),
                                            new DefaultStep("s1", 0, 100, 0.05),
                                            new BeepStep(430,0.1),
                                            new DefaultStep("s1", 0, 100, 0.2),
                                            new BeepStep(380,0.1),
                                            new DefaultStep("s1", 0, 100, 0.1),
                                            new BeepStep(660,0.08),
                                            new DefaultStep("s1", 0, 100, 0.1),
                                            new BeepStep(760,0.05),
                                            new DefaultStep("s1", 0, -100, 0.05),
                                            new BeepStep(860,0.1),
                                            new DefaultStep("s1", 0, -100, 0.2),
                                            new BeepStep(700,0.08),
                                            new DefaultStep("s1", 0, -100, 0.05),
                                            new BeepStep(760,0.05),
                                            new DefaultStep("s1", 0, -100, 0.25),
                                            new BeepStep(660,0.08),
                                            new DefaultStep("s1", 0, -100, 0.2),
                                            new BeepStep(520,0.08),
                                            new DefaultStep("s1", 100, -100, 0.05),
                                            new BeepStep(580,0.08),
                                            new DefaultStep("s1", 100, -100, 0.05),
                                            new BeepStep(480,0.08),
                                            new DefaultStep("s1", 100, -100, 0.4),

                                            new BeepStep(510,0.1),
                                            new DefaultStep("s1", 100, 100, 0.350),
                                            new BeepStep(380,0.1),
                                            new DefaultStep("s1", 100, 100, 0.3),
                                            new BeepStep(320,0.1),
                                            new DefaultStep("s1", 100, 100, 0.4),
                                            new BeepStep(440,0.1),
                                            new DefaultStep("s1", 100, 100, 0.2),
                                            new BeepStep(480,0.08),
                                            new DefaultStep("s1", 100, 100, 0.230),
                                            new BeepStep(450,0.1),
                                            new DefaultStep("s1", 100, 100, 0.05),
                                            new BeepStep(430,0.1),
                                            new DefaultStep("s1", -100, -100, 0.2),
                                            new BeepStep(380,0.1),
                                            new DefaultStep("s1", -100, -100, 0.1),
                                            new BeepStep(660,0.08),
                                            new DefaultStep("s1", -100, -100, 0.1),
                                            new BeepStep(760,0.05),
                                            new DefaultStep("s1", -100, -100, 0.05),
                                            new BeepStep(860,0.1),
                                            new DefaultStep("s1", 100, 0, 0.2),
                                            new BeepStep(700,0.08),
                                            new DefaultStep("s1", 0, 100, 0.05),
                                            new BeepStep(760,0.05),
                                            new DefaultStep("s1", 100, 0, 0.25),
                                            new BeepStep(660,0.08),
                                            new DefaultStep("s1", 0, 100, 0.2),
                                            new BeepStep(520,0.08),
                                            new DefaultStep("s1", 100, 0, 0.05),
                                            new BeepStep(580,0.08),
                                            new DefaultStep("s1", 0, 100, 0.05),
                                            new BeepStep(480,0.08),
                                            new DefaultStep("s1", 100, 0, 0.4),

                                            new BeepStep(500,0.1),
                                            new DefaultStep("s1", 0, -100, 0.2),
                                            new BeepStep(760,0.1),
                                            new DefaultStep("s1", -100, 0, 0.01),
                                            new BeepStep(720,0.1),
                                            new DefaultStep("s1", 0, -100, 0.05),
                                            new BeepStep(680,0.1),
                                            new DefaultStep("s1", -100, 0, 0.05),
                                            new BeepStep(620,0.15),
                                            new DefaultStep("s1", 0, -100, 0.2),

                                            new BeepStep(650,0.15),
                                            new DefaultStep("s1", -100, 100, 0.2),
                                            new BeepStep(380,0.1),
                                            new DefaultStep("s1", -100, 100, 0.05),
                                            new BeepStep(430,0.1),
                                            new DefaultStep("s1", -100, -100, 0.05),

                                            new BeepStep(500,0.1),
                                            new DefaultStep("s1", 100, 0, 0.2),
                                            new BeepStep(430,0.1),
                                            new DefaultStep("s1", 0, 100, 0.05),
                                            new BeepStep(500,0.1),
                                            new DefaultStep("s1", 100, 0, 0.01),
                                            new BeepStep(570,0.1),
                                            new DefaultStep("s1", 0, 100, 0.12),

                                            new BeepStep(500,0.1),
                                            new DefaultStep("s1", -100, 100, 0.2),

                                            new BeepStep(760,0.1),
                                            new DefaultStep("s1", 100, 0, 0.01),
                                            new BeepStep(720,0.1),
                                            new DefaultStep("s1", 0, 100, 0.05),
                                            new BeepStep(680,0.1),
                                            new DefaultStep("s1", 100, 0, 0.05),
                                            new BeepStep(620,0.15),
                                            new DefaultStep("s1", 0, 100, 0.2),

                                            new BeepStep(650,0.20),
                                            new DefaultStep("s1", -100, 100, 0.2),

                                            new BeepStep(1020,0.08),
                                            new DefaultStep("s1", -100, 0, 0.2),
                                            new BeepStep(1020,0.08),
                                            new DefaultStep("s1", 0, -100, 0.05),
                                            new BeepStep(1020,0.08),
                                            new DefaultStep("s1", -100, 0, 0.2),

                                            new BeepStep(380,0.1),
                                            new DefaultStep("s1", 100, -100, 0.2),
                                            new BeepStep(500,0.1),
                                            new DefaultStep("s1", 100, -100, 0.2),

                                            new BeepStep(760,0.1),
                                            new DefaultStep("s1", 100, 100, 0.01),
                                            new BeepStep(720,0.1),
                                            new DefaultStep("s1", 100, 100, 0.05),
                                            new BeepStep(680,0.1),
                                            new DefaultStep("s1", 100, 100, 0.05),
                                            new BeepStep(620,0.15),
                                            new DefaultStep("s1", 100, 100, 0.2),

                                            new BeepStep(650,0.15),
                                            new DefaultStep("s1", -100, -100, 0.2),
                                            new BeepStep(380,0.1),
                                            new DefaultStep("s1", -100, -100, 0.05),
                                            new BeepStep(430,0.1),
                                            new DefaultStep("s1", -100, -100, 0.05),

                                            new BeepStep(500,0.1),
                                            new DefaultStep("s1", -100, 100, 0.2),
                                            new BeepStep(430,0.1),
                                            new DefaultStep("s1", -100, 100, 0.05),
                                            new BeepStep(500,0.1),
                                            new DefaultStep("s1", -100, 100, 0.01),
                                            new BeepStep(570,0.1),
                                            new DefaultStep("s1", -100, 100, 0.32),

                                            new BeepStep(585,0.1),
                                            new DefaultStep("s1", 100, -100, 0.35),

                                            new BeepStep(550,0.1),
                                            new DefaultStep("s1", 100, 0, 0.32),
                                            new BeepStep(500,0.1),
                                            new DefaultStep("s1", 0, 100, 0.26),

                                            new BeepStep(380,0.1),
                                            new DefaultStep("s1", -100, 0, 0.2),
                                            new BeepStep(500,0.1),
                                            new DefaultStep("s1", 0, -100, 0.2),
                                            new BeepStep(500,0.1),
                                            new DefaultStep("s1", -100, 0, 0.05),
                                            new BeepStep(500,0.1),
                                            new DefaultStep("s1", 0, -100, 0.2),

                                            new BeepStep(500,0.1),
                                            new DefaultStep("s1", -100, 100, 0.2),

                                            new BeepStep(760,0.1),
                                            new DefaultStep("s1", 100, 0, 0.01),
                                            new BeepStep(720,0.1),
                                            new DefaultStep("s1", 0, 100, 0.05),
                                            new BeepStep(680,0.1),
                                            new DefaultStep("s1", 100, 0, 0.05),
                                            new BeepStep(620,0.15),
                                            new DefaultStep("s1", 0, 100, 0.2),

                                            new BeepStep(650,0.15),
                                            new DefaultStep("s1", -100, 100, 0.2),
                                            new BeepStep(380,0.1),
                                            new DefaultStep("s1", -100, 100, 0.05),
                                            new BeepStep(430,0.1),
                                            new DefaultStep("s1", -100, 100, 0.05),

                                            new BeepStep(500,0.1),
                                            new DefaultStep("s1", 100, 50, 0.2),
                                            new BeepStep(430,0.1),
                                            new DefaultStep("s1", 100, 50, 0.05),
                                            new BeepStep(500,0.1),
                                            new DefaultStep("s1", 100, 50, 0.01),
                                            new BeepStep(570,0.1),
                                            new DefaultStep("s1", 100, 50, 0.12),

                                            new BeepStep(500,0.1),
                                            new DefaultStep("s1", -100, 100, 0.2),

                                            new BeepStep(760,0.1),
                                            new DefaultStep("s1", 50, 100, 0.01),
                                            new BeepStep(720,0.1),
                                            new DefaultStep("s1", 50, 100, 0.05),
                                            new BeepStep(680,0.1),
                                            new DefaultStep("s1", 50, 100, 0.05),
                                            new BeepStep(620,0.15),
                                            new DefaultStep("s1", 50, 100, 0.2),

                                            new BeepStep(650,0.20),
                                            new DefaultStep("s1", -100, 100, 0.2),

                                            new BeepStep(1020,0.08),
                                            new DefaultStep("s1", 30, 100, 0.2),
                                            new BeepStep(1020,0.08),
                                            new DefaultStep("s1", 30, 100, 0.05),
                                            new BeepStep(1020,0.08),
                                            new DefaultStep("s1", 30, 100, 0.2),

                                            new BeepStep(380,0.1),
                                            new DefaultStep("s1", 100, -100, 0.2),
                                            new BeepStep(500,0.1),
                                            new DefaultStep("s1", 100, -100, 0.2),

                                            new BeepStep(760,0.1),
                                            new DefaultStep("s1", 100, 30, 0.01),
                                            new BeepStep(720,0.1),
                                            new DefaultStep("s1", 100, 30, 0.05),
                                            new BeepStep(680,0.1),
                                            new DefaultStep("s1", 100, 30, 0.05),
                                            new BeepStep(620,0.15),
                                            new DefaultStep("s1", 100, 30, 0.2),

                                            new BeepStep(650,0.15),
                                            new DefaultStep("s1", -100, 100, 0.2),
                                            new BeepStep(380,0.1),
                                            new DefaultStep("s1", -100, 100, 0.05),
                                            new BeepStep(430,0.1),
                                            new DefaultStep("s1", -100, 100, 0.05),

                                            new BeepStep(500,0.1),
                                            new DefaultStep("s1", -100, 50, 0.2),
                                            new BeepStep(430,0.1),
                                            new DefaultStep("s1", -100, 50, 0.05),
                                            new BeepStep(500,0.1),
                                            new DefaultStep("s1", -100, 50, 0.01),
                                            new BeepStep(570,0.1),
                                            new DefaultStep("s1", -100, 50, 0.32),

                                            new BeepStep(585,0.1),
                                            new DefaultStep("s1", -100, 100, 0.35),
                                            new BeepStep(550,0.1),
                                            new DefaultStep("s1", -100, 100, 0.32),
                                            new BeepStep(500,0.1),
                                            new DefaultStep("s1", -100, 100, 0.26),

                                            new BeepStep(380,0.1),
                                            new DefaultStep("s1", 100, -100, 0.2),
                                            new BeepStep(500,0.1),
                                            new DefaultStep("s1", 100, -100, 0.2),
                                            new BeepStep(500,0.1),
                                            new DefaultStep("s1", 100, -100, 0.05),
                                            new BeepStep(500,0.1),
                                            new DefaultStep("s1", 100, -100, 0.2),

                                            new BeepStep(500,0.06),
                                            new DefaultStep("s1", 100, 0, 0.05),
                                            new BeepStep(500,0.08),
                                            new DefaultStep("s1", 0, 100, 0.2),
                                            new BeepStep(500,0.06),
                                            new DefaultStep("s1", 100, 0, 0.25),
                                            new BeepStep(500,0.08),
                                            new DefaultStep("s1", 0, 100, 0.05),
                                            new BeepStep(580,0.08),
                                            new DefaultStep("s1", 100, 0, 0.25),
                                            new BeepStep(660,0.08),
                                            new DefaultStep("s1", 0, 100, 0.05),
                                            new BeepStep(500,0.08),
                                            new DefaultStep("s1", 100, 0, 0.2),
                                            new BeepStep(430,0.08),
                                            new DefaultStep("s1", 0, 100, 0.05),
                                            new BeepStep(380,0.08),
                                            new DefaultStep("s1", 100, 0, 0.5),

                                            new BeepStep(500,0.06),
                                            new DefaultStep("s1", -100, 0, 0.05),
                                            new BeepStep(500,0.08),
                                            new DefaultStep("s1", 0, 100, 0.2),
                                            new BeepStep(500,0.06),
                                            new DefaultStep("s1", -100, 0, 0.25),
                                            new BeepStep(500,0.08),
                                            new DefaultStep("s1", 0, 100, 0.05),
                                            new BeepStep(580,0.08),
                                            new DefaultStep("s1", -100, 0, 0.05),
                                            new BeepStep(660,0.08),
                                            new DefaultStep("s1", 0, 100, 0.45),

                                            new BeepStep(870,0.08),
                                            new DefaultStep("s1", -100, 100, 0.225),
                                            new BeepStep(760,0.08),
                                            new DefaultStep("s1", -100, 100, 0.5),

                                            new BeepStep(500,0.06),
                                            new DefaultStep("s1", 100, 0, 0.05),
                                            new BeepStep(500,0.08),
                                            new DefaultStep("s1", 0, -100, 0.2),
                                            new BeepStep(500,0.06),
                                            new DefaultStep("s1", 100, 0, 0.25),
                                            new BeepStep(500,0.08),
                                            new DefaultStep("s1", 0, -100, 0.05),
                                            new BeepStep(580,0.08),
                                            new DefaultStep("s1", 100, 0, 0.25),
                                            new BeepStep(660,0.08),
                                            new DefaultStep("s1", 0, -100, 0.05),
                                            new BeepStep(500,0.08),
                                            new DefaultStep("s1", 100, 0, 0.2),
                                            new BeepStep(430,0.08),
                                            new DefaultStep("s1", 0, -100, 0.05),
                                            new BeepStep(380,0.08),
                                            new DefaultStep("s1", 100, 0, 0.5),

                                            new BeepStep(660,0.1),
                                            new DefaultStep("s1", 100, 0, 0.05),
                                            new BeepStep(660,0.1),
                                            new DefaultStep("s1", -100, 0, 0.2),
                                            new BeepStep(660,0.1),
                                            new DefaultStep("s1", 100, 0, 0.2),
                                            new BeepStep(510,0.1),
                                            new DefaultStep("s1", -100, 0, 0.01),
                                            new BeepStep(660,0.1),
                                            new DefaultStep("s1", 100, 0, 0.2),
                                            new BeepStep(770,0.1),
                                            new DefaultStep("s1", -100, 100, 0.45),
                                            new BeepStep(380,0.1),
                                            new DefaultStep("s1", 0, 0, 0.45)))),
                            new Choreography("Für Elise", new ArrayList<Step>(
                                    Arrays.asList(
                                            new BeepStep(659, 0.24),  //  Treble E
                                            new DefaultStep("s1", 100, 100, 0.24),
                                            new BeepStep(622, 0.24),  //  Treble D
                                            new DefaultStep("s1", -100, -100, 0.24),
                                            new BeepStep(659, 0.24),  //  Treble E
                                            new DefaultStep("s1", 100, 100, 0.24),
                                            new BeepStep(622, 0.24),  //  Treble D
                                            new DefaultStep("s1", -100, -100, 0.24),
                                            new BeepStep(659, 0.24),  //  Treble E
                                            new DefaultStep("s1", 100, 100, 0.24),
                                            new BeepStep(494, 0.24),  //  Treble B
                                            new DefaultStep("s1", 0, 100, 0.24),
                                            new BeepStep(587, 0.24),  //  Treble D
                                            new DefaultStep("s1", 0, -100, 0.24),
                                            new BeepStep(523, 0.24),  //  Treble C
                                            new DefaultStep("s1", 100, -100, 0.24),
                                            new BeepStep(440, 0.48),  //  Treble A
                                            new DefaultStep("s1", 100, 100, 0.24),
                                            new BeepStep(262, 0.24),  //  Middle C
                                            new DefaultStep("s1", -100, -100, 0.24),
                                            new BeepStep(330, 0.24),  //  Treble E
                                            new DefaultStep("s1", 100, 0, 0.24),
                                            new BeepStep(440, 0.24),  //  Treble A
                                            new DefaultStep("s1", -100, 0, 0.24),
                                            new BeepStep(494, 0.48),  //  Treble B
                                            new DefaultStep("s1", -100, -100, 0.24),
                                            new BeepStep(330, 0.24),  //  Treble E
                                            new DefaultStep("s1", 0, 100, 0.24),
                                            new BeepStep(415, 0.24),  //  Treble G
                                            new DefaultStep("s1", 100, 0, 0.24),
                                            new BeepStep(494, 0.24),  //  Treble B
                                            new DefaultStep("s1", 0, 100, 0.24),
                                            new BeepStep(523, 0.48),  //  Treble C
                                            new DefaultStep("s1", 0, -100, 0.24),
                                            new BeepStep(330, 0.24),  //  Treble E
                                            new DefaultStep("s1", -100, 0, 0.24),
                                            new BeepStep(659, 0.24),  //  Treble E
                                            new DefaultStep("s1", 100, 100, 0.24),
                                            new BeepStep(622, 0.24),  //  Treble D
                                            new DefaultStep("s1", -100, -100, 0.24),
                                            new BeepStep(659, 0.24),  //  Treble E
                                            new DefaultStep("s1", 100, 100, 0.24),
                                            new BeepStep(622, 0.24),  //  Treble D
                                            new DefaultStep("s1", -100, -100, 0.24),
                                            new BeepStep(659, 0.24),  //  Treble E
                                            new DefaultStep("s1", 100, 100, 0.24),
                                            new BeepStep(494, 0.24),  //  Treble B
                                            new DefaultStep("s1", 0, 100, 0.24),
                                            new BeepStep(587, 0.24),  //  Treble D
                                            new DefaultStep("s1", 0, -100, 0.24),
                                            new BeepStep(523, 0.24),  //  Treble C
                                            new DefaultStep("s1", 100, -100, 0.24),
                                            new BeepStep(440, 0.48),  //  Treble A
                                            new DefaultStep("s1", -100, 50, 0.24),
                                            new BeepStep(262, 0.24),  //  Middle C
                                            new DefaultStep("s1", 50, -100, 0.24),
                                            new BeepStep(330, 0.24),  //  Treble E
                                            new DefaultStep("s1", 30, -100, 0.24),
                                            new BeepStep(440, 0.24),  //  Treble A
                                            new DefaultStep("s1", -100, 30, 0.24),
                                            new BeepStep(494, 0.48),  //  Treble B
                                            new DefaultStep("s1", 100, 50, 0.24),
                                            new BeepStep(330, 0.24),  //  Treble E
                                            new DefaultStep("s1", 50, 100, 0.24),
                                            new BeepStep(523, 0.24),  //  Treble C
                                            new DefaultStep("s1", -100, 100, 0.24),
                                            new BeepStep(494, 0.48),  //  Treble B
                                            new DefaultStep("s1", 100, -100, 0.24),
                                            new BeepStep(440, 0.48)))),  //  Treble A
                            new Choreography("Yankee Doodle", new ArrayList<Step>(
                                    Arrays.asList(
                                            new BeepStep(262, 0.2), // C
                                            new DefaultStep("s1", 0, 100, 0.2),
                                            new BeepStep(262, 0.2), // C
                                            new DefaultStep("s2", 100, 0, 0.2),
                                            new BeepStep(294, 0.2), // D
                                            new DefaultStep("s3", 0, 100, 0.2),
                                            new BeepStep(330, 0.2), // E
                                            new DefaultStep("s4", 100, 0, 0.2),
                                            new BeepStep(262, 0.2), // C
                                            new DefaultStep("s5", -100, 0, 0.2),
                                            new BeepStep(330, 0.2), // E
                                            new DefaultStep("s6", 0, -100, 0.2),
                                            new BeepStep(294, 2 * 0.2), // D (double length)
                                            new DefaultStep("s7", -100, 0, 0.2),
                                            new BeepStep(262, 0.2), // C
                                            new DefaultStep("s8", 100, 0, 0.2),
                                            new BeepStep(262, 0.2), // C
                                            new DefaultStep("s9", 0, 100, 0.2),
                                            new BeepStep(294, 0.2), // D
                                            new DefaultStep("s10", 100, 0, 0.2),
                                            new BeepStep(330, 0.2), // E
                                            new DefaultStep("s11", 0, 100, 0.2),
                                            new BeepStep(262, 2 * 0.2), // C (double length),
                                            new DefaultStep("s12", 100, -100, 0.2),
                                            new BeepStep(247, 2 * 0.2), // B (double length),
                                            new DefaultStep("s13", -100, 100, 0.2),
                                            new BeepStep(262, 0.2), // C
                                            new DefaultStep("s14", 0, 100, 0.2),
                                            new BeepStep(262, 0.2), // C
                                            new DefaultStep("s15", 0, 100, 0.2),
                                            new BeepStep(294, 0.2), // D
                                            new DefaultStep("s16", 0, 100, 0.2),
                                            new BeepStep(330, 0.2), // E
                                            new DefaultStep("s17", 0, 100, 0.2),
                                            new BeepStep(349, 0.2), // F
                                            new DefaultStep("s18", 0, -100, 0.2),
                                            new BeepStep(330, 0.2), // E
                                            new DefaultStep("s19", 0, -100, 0.2),
                                            new BeepStep(294, 0.2), // D
                                            new DefaultStep("s20", 0, -100, 0.2),
                                            new BeepStep(262, 0.2), // C
                                            new DefaultStep("s21", 0, -100, 0.2),
                                            new BeepStep(247, 0.2), // B
                                            new DefaultStep("s22", 0, -100, 0.2),
                                            new BeepStep(196, 0.2), // G
                                            new DefaultStep("s23", -100, 0, 0.2),
                                            new BeepStep(220, 0.2), // A
                                            new DefaultStep("s24", 100, 0, 0.2),
                                            new BeepStep(247, 0.2), // B
                                            new DefaultStep("s25", -100, 0, 0.2),
                                            new BeepStep(262, 2 * 0.2), // C (double length),
                                            new DefaultStep("s26", -100, 100, 0.2),
                                            new BeepStep(262, 2 * 0.2))))) // C (double length)
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
