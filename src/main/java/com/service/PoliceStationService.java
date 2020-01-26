package com.service;

import com.beans.PoliceStationRequest;
import com.beans.StationResponse;
import com.domain.PoliceStation;

import java.util.List;

public interface PoliceStationService {

    void registerPoliceStation(PoliceStationRequest station);

    List<StationResponse> getPoliceStations();

    StationResponse getParticularPoliceStation(String pincode);
}
