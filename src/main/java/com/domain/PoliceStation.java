package com.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PoliceStation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int stationId;
    private String stationName;
    private String place;
    private String district;
    private String state;
    private String address;
    private String pincode;
    private long phoneNumber;
}
