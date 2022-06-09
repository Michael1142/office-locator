package com.solirius.hosehackathon.utilities;

import com.opencsv.exceptions.CsvException;
import com.solirius.hosehackathon.domain.Office;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateTest {

    @Test
    void noDistance() {
        double distance = Calculate.distance(0, 0, 0, 0);
        assertEquals(0, distance);
    }

    @Test
    void distanceBetweenLondonAndCambridge() {
        double distance = Calculate.distance(51.5072, 0.1276, 52.1951, 0.1313);
        assertEquals(0.6879099505022432, distance, 0.01);
    }

    @Test
    void findShortest() throws IOException, CsvException {
        Office closestOffice = Calculate.findClosestOffice(0, 0);
        assertEquals("\"Marazion Marsh\"", closestOffice.getName());
    }


}