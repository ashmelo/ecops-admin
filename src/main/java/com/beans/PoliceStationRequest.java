package com.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoliceStationRequest {

    private String stationName;
    private String place;
    private String district;
    private String state;
    private String address;
    private String pincode;
    private long phoneNumber;

}
