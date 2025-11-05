package com.sushant.parkingSystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sushant.parkingSystem.enums.Type;
import com.sushant.parkingSystem.model.ParkingSlot;

@Repository
public interface ParkingSlotRepo extends JpaRepository<ParkingSlot,Long>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM parking_slot where status = 'AVAILABLE' and type = :type and parking_lot_id = :lotid limit 1")
	List<ParkingSlot> findAvailableByTypeAndLotid(Type type , long lotid);
	

}