package com.repository;

import com.domain.CrimeStatus;
import com.domain.PoliceOfficer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoliceOfficerRepository extends JpaRepository<PoliceOfficer, Integer> {

    PoliceOfficer findByEmailAndPassword(String email, String password);

    @Query("select p from PoliceOfficer p where p.station.stationId = :id and p.crimeDepartment = :crimeType")
    List<PoliceOfficer> findByStationIdAndDepartment(int id, CrimeStatus crimeType);

    PoliceOfficer findByLoginId(String loginId);
}
