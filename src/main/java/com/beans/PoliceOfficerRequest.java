package com.beans;


import com.domain.CrimeStatus;
import com.domain.PoliceStation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoliceOfficerRequest {

    @NotNull(message = "firstName cannot be null")
    @NotEmpty(message = "firstName cannot be empty")
    private String firstName;
    private String lastName;
    @NotNull(message = "email cannot be null")
    @NotEmpty(message = "email cannot be empty")
    private String email;
    private String sex;
    @NotNull(message = "contact cannot be null")
    @NotEmpty(message = "contact cannot be empty")
    private String contact;
    private String designation;
    @NotNull(message = "stationId cannot be null")
    @NotEmpty(message = "stationId cannot be empty")
    private int stationId;
    @NotNull(message = "crimeDepartment cannot be null")
    @NotEmpty(message = "crimeDepartment cannot be empty")
    private CrimeStatus crimeDepartment;
    private Instant joinDate;
    @NotNull(message = "loginId cannot be null")
    @NotEmpty(message = "loginId cannot be empty")
    private String loginId;
    @NotNull(message = "password cannot be null")
    @NotEmpty(message = "password cannot be empty")
    private String password;
}
