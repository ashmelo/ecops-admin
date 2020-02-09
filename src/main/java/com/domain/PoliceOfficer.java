package com.domain;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PoliceOfficer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "police_officer_generator")
    @SequenceGenerator(name="police_officer_generator", sequenceName = "officer_seq", initialValue = 1, allocationSize = 50)
    private int policeId;
    private String firstName;
    private String lastName;
    private String email;
    private String sex;
    private String designation;
    private String contact;
    private String loginId;

    @OneToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name="station_id")
    private PoliceStation station;

    @Enumerated(EnumType.STRING)
    private CrimeStatus crimeDepartment;
    private Instant joinDate;
    private String password;

}
