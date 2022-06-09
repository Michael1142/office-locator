package com.solirius.hosehackathon.utilities;

import com.opencsv.exceptions.CsvException;
import com.solirius.hosehackathon.domain.Office;

import java.io.IOException;
import java.util.List;

import static java.lang.Math.sqrt;

public class Calculate {


    public static Office findClosestOffice(double lat, double lon) throws IOException, CsvException {
        List<Office> offices = new OfficeImporter().importCsv();

        return findClosestOffice(offices, lat, lon);
    }

    public static Office findClosestOffice(List<Office> offices, double lat, double lon) throws IOException, CsvException {
        double shortest = -1;
        Office res = null;
        for (Office office : offices) {
            double newDistance = distance(office.getLatitude(), office.getLongitude(), lat, lon);
            if (shortest == -1 || shortest > newDistance) {
                shortest = newDistance;
                res = office;
            }
        }

        return res;
    }

    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        return sqrt((lat2 - lat1) * (lat2 - lat1) + (lon2 - lon1) * (lon2 - lon1));
    }
}
