package com.mspring.repository;

import com.mspring.model.Satellite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SatelliteService {

    private final RestTemplate restTemplate;
    private static final String SATELLITE_API_URL = "https://api.wheretheiss.at/v1/satellites/25544";

    @Autowired
    public SatelliteService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Method to get satellite data
    public Satellite getSatelliteData() {
        return restTemplate.getForObject(SATELLITE_API_URL, Satellite.class);
    }
}
