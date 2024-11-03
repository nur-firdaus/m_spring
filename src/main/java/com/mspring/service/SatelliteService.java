package com.mspring.service;

import com.mspring.model.Satellite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SatelliteService {
    @Autowired
    private RestTemplate restTemplate;
    private static final String SATELLITE_API_URL = "https://api.wheretheiss.at/v1/satellites/25544";

    public Satellite getSatelliteData() {
        return restTemplate.getForObject(SATELLITE_API_URL, Satellite.class);
    }
}
