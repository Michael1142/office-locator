package com.solirius.hosehackathon.utilities;

import java.time.Duration;

public class Calculate {

    /**
     *
     * @param milesDistance
     * @param duration
     * @return the resulting speed as milesDistance/hour
     */
    public static double speed(double milesDistance, Duration duration){
        //Calculate speed
        return 0;
    }

    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        return sqrt((lat2 - lat1) * (lat2 - lat1) + (lon2 - lon1) * (lon2 - lon1))
    }
}
