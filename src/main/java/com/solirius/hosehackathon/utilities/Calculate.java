package com.solirius.hosehackathon.utilities;

import com.opencsv.exceptions.CsvException;
import com.solirius.hosehackathon.domain.Office;

import java.io.IOException;
import java.util.List;

import static java.lang.Math.sqrt;

public class Calculate {


    public static Office findClosestOffice(double lat, double lon) throws IOException, CsvException {
        List<Office> offices = new OfficeImporter().importCsv();

        return findClosestOffice(offices, lat, lon, false, false, false, false, false, false, false, false, false);
    }

    public static Office findClosestOffice(List<Office> offices, double lat, double lon,
                                           boolean wifi,
                                           boolean extendedAccess, boolean meetingRooms,
                                           boolean kitchen, boolean breakArea,
                                           boolean petFriendly, boolean printing,
                                           boolean shower, boolean optimised
    ) {
        double shortest = -1;
        Office res = null;
        if (optimised) {
            for (Office office : offices) {
                int facilityCount = getFacilityCount(wifi, extendedAccess, meetingRooms, kitchen, breakArea, petFriendly, printing, shower, office);
                double newDistance = distance(office.getLatitude(), office.getLongitude(), lat, lon);
                if (newDistance < 5) {
                    shortest = newDistance;
                    res = office;
                } else if ((newDistance > 5 && newDistance < 10) && facilityCount >= 2) {
                    shortest = newDistance;
                    res = office;
                } else {
                    if (shortest == -1 || shortest > newDistance) {
                        shortest = newDistance;
                        res = office;
                    }
                }
            }
        } else {
            for (Office office : offices) {
                int facilityCount = 0;
                if (wifi && !office.isWifi()) {
                    facilityCount++;
                    continue;
                }
                if (extendedAccess && !office.isWifi()) {
                    facilityCount++;
                    continue;
                }
                if (meetingRooms && !office.isMeetingRooms()) {
                    facilityCount++;
                    continue;
                }
                if (kitchen && !office.isKitchen()) {
                    facilityCount++;
                    continue;
                }
                if (breakArea && !office.isBreakArea()) {
                    facilityCount++;
                    continue;
                }
                if (petFriendly && !office.isPetFriendly()) {
                    facilityCount++;
                    continue;
                }
                if (printing && !office.isPrinting()) {
                    facilityCount++;
                    continue;
                }
                if (shower && !office.isShower()) {
                    facilityCount++;
                    continue;
                }


                double newDistance = distance(office.getLatitude(), office.getLongitude(), lat, lon);
                if (shortest == -1 || shortest > newDistance) {
                    shortest = newDistance;
                    res = office;
                }
            }

        }
        return res;
    }


    private static int getFacilityCount(boolean wifi, boolean extendedAccess, boolean meetingRooms, boolean kitchen, boolean breakArea, boolean petFriendly, boolean printing, boolean shower, Office office) {
        int facilityCount = 0;
        if (wifi && !office.isWifi()) {
            facilityCount++;
        }
        if (extendedAccess && !office.isWifi()) {
            facilityCount++;
        }
        if (meetingRooms && !office.isMeetingRooms()) {
            facilityCount++;
        }
        if (kitchen && !office.isKitchen()) {
            facilityCount++;
        }
        if (breakArea && !office.isBreakArea()) {
            facilityCount++;
        }
        if (petFriendly && !office.isPetFriendly()) {
            facilityCount++;
        }
        if (printing && !office.isPrinting()) {
            facilityCount++;
        }
        if (shower && !office.isShower()) {
            facilityCount++;
        }
        return facilityCount;
    }

    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        return sqrt((lat2 - lat1) * (lat2 - lat1) + (lon2 - lon1) * (lon2 - lon1));
    }
}

