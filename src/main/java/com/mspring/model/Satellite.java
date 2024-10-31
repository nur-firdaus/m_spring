package com.mspring.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Satellite {

    private String name;
    private Long id;
    private Double latitude;
    private Double longitude;
    private Double altitude;
    private Double velocity;
    private String visibility;
    private Double footprint;
    private Long timestamp;
    private Double daynum;
    private Double solar_lat;
    private Double solar_lon;
    private String units;
}
