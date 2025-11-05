package com.sushant.parkingSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sushant.parkingSystem.model.Vehicle;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle,Long>{
	
	@Query(value="select * from vehicle v where v.plate_number=:plateNumber" , nativeQuery=true)
	public Vehicle findByPlateNumber(String plateNumber);
}
