package com.sushant.parkingSystem.service;

import com.sushant.parkingSystem.model.Vehicle;

public interface VehicleService {

	Vehicle addVehicle(Vehicle vehicle);
	Vehicle getByPlateNumber(String plateNumber);

}