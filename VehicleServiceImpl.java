package com.sushant.parkingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sushant.parkingSystem.model.Vehicle;
import com.sushant.parkingSystem.repo.VehicleRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	VehicleRepo vehicleRepo;
	
	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		return vehicleRepo.save(vehicle);
	}

	@Override
	public Vehicle getByPlateNumber(String plateNumber) {
		return vehicleRepo.findByPlateNumber(plateNumber);
	}
}
