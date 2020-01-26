package com.beans;


import com.domain.CrimeStatus;
import com.domain.PoliceStation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoliceOfficerRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String sex;
    private String contact;
    private String designation;
    private int stationId;
    private CrimeStatus crimeDepartment;
    private Instant joinDate;
    private String loginId;
    private String password;
}
