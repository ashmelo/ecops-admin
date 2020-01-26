package com.service.implementation;

import com.beans.PoliceStationRequest;
import com.beans.StationResponse;
import com.domain.PoliceStation;
import com.repository.PoliceStationRepository;
import com.service.PoliceStationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PoliceStationServiceImpl implements PoliceStationService {

    PoliceStationRepository stationRepository;

    @Override
    public void registerPoliceStation(PoliceStationRequest stationRequest) {
        PoliceStation station = PoliceStation.builder()
                .address(stationRequest.getAddress())
                .district(stationRequest.getDistrict())
                .phoneNumber(stationRequest.getPhoneNumber())
                .pincode(stationRequest.getPincode())
                .place(stationRequest.getPlace())
                .state(stationRequest.getState())
                .stationName(stationRequest.getStationName()).build();
        stationRepository.saveAndFlush(station);
    }

    @Override
    public List<StationResponse> getPoliceStations() {
        List<PoliceStation> stationList =stationRepository.findAll();
        List<StationResponse> stations = new ArrayList<>();
        stationList.forEach(s->{
            StationResponse station = StationResponse.builder()
                    .stationId(s.getStationId())
                    .address(s.getAddress())
                    .pincode(s.getPincode())
                    .place(s.getPlace())
                    .stationName(s.getStationName()).build();
            stations.add(station);
        });
        return stations;
    }

    @Override
    public StationResponse getParticularPoliceStation(String pincode) {
        PoliceStation policeStation = stationRepository.findByPincodeContaining(pincode);
        StationResponse station = StationResponse.builder()
                .stationId(policeStation.getStationId())
                .address(policeStation.getAddress())
                .pincode(policeStation.getPincode())
                .place(policeStation.getPlace())
                .stationContact(String.valueOf(policeStation.getPhoneNumber()))
                .stationName(policeStation.getStationName()).build();
        return station;
    }
}
