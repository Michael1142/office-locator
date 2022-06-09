package com.solirius.hosehackathon.utilities;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateTest {

    @Test
    void noDistance() {
        double distance = Calculate.distance(0,0, 0, 0);
        assertEquals(0, distance);
    }

    @Test
    void distanceBetweenLondonAndCambridge() {
        double distance = Calculate.distance(51.5072, 0.1276, 52.1951, 0.1313);
        assertEquals(0.6879099505022432, distance, 0.01);
    }


}