package com.controller;

import com.beans.*;
import com.domain.CrimeStatus;
import com.domain.PoliceOfficer;
import com.domain.PoliceStation;
import com.service.PoliceOfficerService;
import com.service.PoliceStationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/api/v1")
@Api(value = "Manage police stations and officers")
@AllArgsConstructor
public class AdminController {

    PoliceStationService stationService;
    PoliceOfficerService officerService;

    @PostMapping(value = "/register_station", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Register a new police station")
    public ResponseEntity registerStation(@RequestBody PoliceStationRequest station) {
        stationService.registerPoliceStation(station);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(value = "/register_police_officer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Register a police police")
    public ResponseEntity registerPoliceOfficer(@RequestBody PoliceOfficerRequest officer) {
        officerService.registerPoliceStation(officer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/police_login_token", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Police Information")
    public ResponseEntity<TokenResponse> getPoliceInfo(@RequestParam("login") String login, @RequestParam("password") String password) {
        return new ResponseEntity<TokenResponse>(officerService.getPoliceLoginToken(login,password),HttpStatus.OK);
    }

    @GetMapping(value = "/police_stations", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Police Stations")
    public ResponseEntity<List<StationResponse>> getPoliceStations() {
        return new ResponseEntity<List<StationResponse>>(stationService.getPoliceStations(),HttpStatus.OK);
    }

    @GetMapping(value = "/get_police_station", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Police Stations")
    public ResponseEntity<StationResponse> getParticularPoliceStation(@RequestParam("pincode") String pincode) {
        return new ResponseEntity<StationResponse>(stationService.getParticularPoliceStation(pincode),HttpStatus.OK);
    }

    @GetMapping(value = "/get_police_officer", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Police Officer for particular station id")
    public ResponseEntity<OfficerResponse> getParticularPoliceOfficer(@RequestParam("id") int id, @RequestParam("crimeType") CrimeStatus crimeType) {
        return new ResponseEntity<OfficerResponse>(officerService.getParticularPoliceOfficer(id, crimeType),HttpStatus.OK);
    }

    @GetMapping(value = "/get_police_officer_details", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Police Officer for particular station id")
    public ResponseEntity<OfficerResponse> getParticularPoliceOfficerWithLoginId(@RequestParam("loginId") String loginId) {
        return new ResponseEntity<OfficerResponse>(officerService.getParticularPoliceOfficerWithLoginId(loginId),HttpStatus.OK);
    }
}
