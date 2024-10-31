package com.mspring.controller;

import com.mspring.model.Satellite;
import com.mspring.repository.SatelliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/satellites")
public class SatelliteController {

    @Autowired
    SatelliteService satelliteService;

    @GetMapping("/iss")
    public ResponseEntity<Satellite> getSatellite() {
        Satellite satellite = satelliteService.getSatelliteData();
        return ResponseEntity.ok(satellite);
    }
}
