package com.solirius.hosehackathon.controller;

import com.solirius.hosehackathon.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OfficeLocatorController {

    @Autowired
    private OfficeRepository officeRepository;

/*    @GetMapping({"/locate-offices"})
    public Office greeting(double lat, double lon) {

        Iterable<Office> all = officeRepository.findAll();

        List offices = new ArrayList();
        for (Office office : all) {
            offices.add(office);
        }
        Office res = null;
        try {
            res = Calculate.findClosestOffice(offices, lat, lon);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }*/

}
