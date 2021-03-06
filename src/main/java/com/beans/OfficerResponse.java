package com.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class OfficerResponse {

    private int id;
    private String loginId;
    private String name;
    private String password;
    private String contact;
}
