package com.repository;

import com.beans.StationResponse;
import com.domain.PoliceStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliceStationRepository extends JpaRepository<PoliceStation, Integer> {

    PoliceStation findByPincodeContaining(String pincode);
}
