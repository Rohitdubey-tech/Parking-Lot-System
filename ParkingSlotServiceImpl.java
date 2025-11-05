package com.sushant.parkingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sushant.parkingSystem.enums.Type;
import com.sushant.parkingSystem.model.ParkingSlot;
import com.sushant.parkingSystem.repo.ParkingSlotRepo;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class ParkingSlotServiceImpl implements ParkingSlotService{

	@Autowired
	ParkingSlotRepo parkingSlotRepo;
	
	@Override
	public ParkingSlot addParkingSlot(ParkingSlot parkingSlot) {		
		return parkingSlotRepo.save(parkingSlot);
	}
	
	@Override
	public List<ParkingSlot> addAll(List<ParkingSlot> parkingSlots) {		
		return parkingSlotRepo.saveAll(parkingSlots);
	}

	@Override
	public List<ParkingSlot> findEmptySlots(Type type,Long parkingLotId) {
		return parkingSlotRepo.findAvailableByTypeAndLotid(type , parkingLotId);
	}

	@Override
	public ParkingSlot findOne(Long parkingSlotId) {
		
		Optional<ParkingSlot> opt = parkingSlotRepo.findById(parkingSlotId);
		return opt.get();
	}

}
