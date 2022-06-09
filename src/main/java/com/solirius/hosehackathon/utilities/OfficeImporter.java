package com.solirius.hosehackathon.utilities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.solirius.hosehackathon.domain.Office;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OfficeImporter {


    public List<Office> importCsv() throws IOException, CsvException {

        ArrayList<Office> offices = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/test-offices.csv"))) {
            List<String[]> r = reader.readAll();
            r.forEach(x -> {
                System.out.println(Arrays.toString(x));
                Office office = new Office(Double.valueOf(x[0]), Double.valueOf(x[1]), x[2].trim());
                offices.add(office);
            });


        }

        return offices;
    }
}
