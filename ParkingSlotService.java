package com.sushant.parkingSystem.service;


import java.util.List;

import com.sushant.parkingSystem.enums.Type;
import com.sushant.parkingSystem.model.ParkingSlot;

public interface ParkingSlotService {
	ParkingSlot addParkingSlot(ParkingSlot parkingSlot);
	List<ParkingSlot> addAll(List<ParkingSlot> parkingSlots);
	List<ParkingSlot> findEmptySlots(Type type,Long parkingLotId );
	
	ParkingSlot findOne(Long parkingSlotId);
}
