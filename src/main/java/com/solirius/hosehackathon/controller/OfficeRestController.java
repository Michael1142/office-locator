package com.solirius.hosehackathon.controller;

import com.solirius.hosehackathon.domain.Office;
import com.solirius.hosehackathon.repository.OfficeRepository;
import com.solirius.hosehackathon.utilities.Calculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
public class OfficeRestController {

    @Autowired
    private OfficeRepository officeRepository;


/*    @GetMapping(value = "/offices")
    public Iterable<Office> findAll() {
        return officeRepository.findAll();
    }*/

    @GetMapping(value = "/offices")
    public Iterable<Office> findAll(@RequestParam(required = false) Double latitude, @RequestParam(required = false) Double longitude) {
        Iterable<Office> all = officeRepository.findAll();

        if (latitude == null || longitude == null) {
            return all;
        }
        List offices = new ArrayList();
        for (Office office : all) {
            offices.add(office);
        }
        Office res = null;
        try {
            res = Calculate.findClosestOffice(offices, latitude, longitude);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return Collections.singleton(res);
    }

    @PostMapping(value = "/offices")
    public Office saveOffice(Office office) {
        return officeRepository.save(office);
    }

    @GetMapping(value = "/offices/{id}")
    public Optional<Office> findById(@PathVariable Long id) {
        return officeRepository.findById(id);
    }
}
