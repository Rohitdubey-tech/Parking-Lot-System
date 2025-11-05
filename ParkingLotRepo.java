package com.sushant.parkingSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sushant.parkingSystem.model.ParkingLot;

@Repository
public interface ParkingLotRepo extends JpaRepository<ParkingLot,Long>{

}
