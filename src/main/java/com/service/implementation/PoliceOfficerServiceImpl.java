package com.service.implementation;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.beans.OfficerResponse;
import com.beans.PoliceOfficerRequest;
import com.beans.TokenResponse;
import com.domain.CrimeStatus;
import com.domain.PoliceOfficer;
import com.repository.PoliceOfficerRepository;
import com.repository.PoliceStationRepository;
import com.service.PoliceOfficerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PoliceOfficerServiceImpl implements PoliceOfficerService {

    PoliceOfficerRepository officerRepository;
    PoliceStationRepository stationRepository;

    @Override
    public void registerPoliceStation(PoliceOfficerRequest officerRequest) {
        PoliceOfficer officer = PoliceOfficer.builder()
                .crimeDepartment(officerRequest.getCrimeDepartment())
                .designation(officerRequest.getDesignation())
                .firstName(officerRequest.getFirstName())
                .joinDate(officerRequest.getJoinDate())
                .lastName(officerRequest.getLastName())
                .password(officerRequest.getPassword())
                .loginId(officerRequest.getLoginId())
                .sex(officerRequest.getSex())
                .contact(officerRequest.getContact())
                .station(stationRepository.getOne(officerRequest.getStationId()))
                .email(officerRequest.getEmail()).build();
        officerRepository.saveAndFlush(officer);
    }

    @Override
    public TokenResponse getPoliceLoginToken(String login, String password) {
        PoliceOfficer policeOfficer = officerRepository.findByEmailAndPassword(login,password);
        Algorithm algorithm = Algorithm.HMAC256("tokenSecret");
        String token = JWT.create()
                .withClaim("id", policeOfficer.getLoginId())
                .withClaim("password", policeOfficer.getPassword())
                .withClaim("contact", policeOfficer.getContact())
                .sign(algorithm);
        return TokenResponse.builder().token(token).build();
    }

    @Override
    public OfficerResponse getParticularPoliceOfficer(int id, CrimeStatus crimeType) {
        List<PoliceOfficer> officer = officerRepository.findByStationIdAndDepartment(id,crimeType);
        OfficerResponse officerResponse = OfficerResponse.builder()
                .id(officer.get(0).getPoliceId())
                .name(officer.get(0).getFirstName()+" "+officer.get(0).getLastName()).build();
        return officerResponse;
    }

    @Override
    public OfficerResponse getParticularPoliceOfficerWithLoginId(String loginId) {
        PoliceOfficer policeOfficer = officerRepository.findByLoginId(loginId);
        OfficerResponse officerResponse = OfficerResponse.builder().id(policeOfficer.getPoliceId())
                .loginId(policeOfficer.getLoginId()).name(policeOfficer.getFirstName()+" "+policeOfficer.getLastName()).contact(policeOfficer.getContact())
                .password(policeOfficer.getPassword()).build();
        return officerResponse;
    }
}
