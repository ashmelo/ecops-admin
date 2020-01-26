package com.service;

import com.beans.OfficerResponse;
import com.beans.PoliceOfficerRequest;
import com.beans.TokenResponse;
import com.domain.CrimeStatus;
import com.domain.PoliceOfficer;

public interface PoliceOfficerService {

    void registerPoliceStation(PoliceOfficerRequest officer);

    TokenResponse getPoliceLoginToken(String login, String password);

    OfficerResponse getParticularPoliceOfficer(int id, CrimeStatus crimeType);
}
