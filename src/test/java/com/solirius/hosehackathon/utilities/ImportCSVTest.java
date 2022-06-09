package com.solirius.hosehackathon.utilities;

import com.opencsv.exceptions.CsvException;
import com.solirius.hosehackathon.domain.Office;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImportCSVTest {

    @Test
    void testImport() throws IOException, CsvException {
        OfficeImporter importer = new OfficeImporter();
        List<Office> offices = importer.importCsv();
        assertEquals(170, offices.size());
    }




}