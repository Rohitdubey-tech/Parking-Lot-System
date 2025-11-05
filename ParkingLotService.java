package com.sushant.parkingSystem.service;

import java.util.List;


import com.sushant.parkingSystem.customException.ParkingLotException;
import com.sushant.parkingSystem.model.ParkingLot;

public interface ParkingLotService {

	ParkingLot getByid(Long id) throws ParkingLotException;

	List<ParkingLot> getAllParkingLot();

	ParkingLot addParkingLot(ParkingLot parkingLot) throws ParkingLotException;

	ParkingLot deleteParkingLot(ParkingLot parkingLot) throws ParkingLotException;

	ParkingLot updateParkingLot(ParkingLot parkingLot) throws ParkingLotException;

}