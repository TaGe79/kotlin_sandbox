package org.tage.sample.java.fromKotlin;
// time java -cp build/libs/mic_importer-1.0-SNAPSHOT.jar org.tage.sample.java.fromKotlin.KotlinTest UDDLLRUUUDUURUDDUULLDRRRR

import org.tage.sample.robot.RobotPosition;

/**
 *
 */
public class KotlinTest {
    public static void main(String[] args) {
        for (final String moves : args)
            System.out.println(RobotPosition.Companion.javaFinalPosition(moves));
    }
}
