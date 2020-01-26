package com.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class StationResponse {

    private int stationId;
    private String stationName;
    private String pincode;
    private String address;
    private String place;
    private String stationContact;
}
