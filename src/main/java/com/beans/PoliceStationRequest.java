package com.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoliceStationRequest {

    @NotNull(message = "stationName cannot be null")
    @NotEmpty(message = "stationName cannot be empty")
    private String stationName;
    @NotNull(message = "place cannot be null")
    @NotEmpty(message = "place cannot be empty")
    private String place;
    @NotNull(message = "district cannot be null")
    @NotEmpty(message = "district cannot be empty")
    private String district;
    @NotNull(message = "state cannot be null")
    @NotEmpty(message = "state cannot be empty")
    private String state;
    @NotNull(message = "address cannot be null")
    @NotEmpty(message = "address cannot be empty")
    private String address;
    @NotNull(message = "pincode cannot be null")
    @NotEmpty(message = "pincode cannot be empty")
    private String pincode;
    @NotNull(message = "phoneNumber cannot be null")
    @NotEmpty(message = "phoneNumber cannot be empty")
    private long phoneNumber;

}
