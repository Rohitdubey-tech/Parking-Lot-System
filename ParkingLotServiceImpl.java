package com.sushant.parkingSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sushant.parkingSystem.customException.ParkingLotException;
import com.sushant.parkingSystem.enums.Status;
import com.sushant.parkingSystem.enums.Type;
import com.sushant.parkingSystem.model.ParkingLot;
import com.sushant.parkingSystem.model.ParkingSlot;
import com.sushant.parkingSystem.repo.ParkingLotRepo;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class ParkingLotServiceImpl implements ParkingLotService {
	
	private static final Logger log = LoggerFactory.getLogger(ParkingLotServiceImpl.class);
	
	@Autowired
	ParkingLotRepo parkingLotRepo;
	
	@Autowired
	ParkingSlotService parkingSlotService;

	@Override
	public ParkingLot getByid(Long id) throws ParkingLotException {		
		log.debug("findyById for Parking Lot has been called");
		
		try {
			Optional<ParkingLot> opt = parkingLotRepo.findById(id);
			if(opt.isEmpty()) {
				throw new ParkingLotException("parking lot not found");
			}
			return opt.get();
		} catch (Exception e) {
			log.error("Id not found");
			throw new ParkingLotException("Id not found");
		}
	}
	
	
	@Override
	public List<ParkingLot> getAllParkingLot(){
		log.debug("getting all parking lot");
		
		return parkingLotRepo.findAll();
	}
	
	
	@Override
	public ParkingLot addParkingLot(ParkingLot parkingLot) throws ParkingLotException {
		log.debug("addParkingLot has been called for {}",parkingLot.getName());	
		
		try {
			parkingLotRepo.save(parkingLot);
			
			int totalSlots = parkingLot.getTotalParkingSlots();
			int car = (int)(totalSlots * 0.5);
			int bike = (int)(totalSlots * 0.3);
			
			int carCounter=0,bikeCounter=0;
			List<ParkingSlot> slots = new ArrayList<>();
			
			for(int i=1;i<=totalSlots;i++) {
				ParkingSlot slot = new ParkingSlot();
				slot.setSlotNumber("s" + i);
				slot.setParkingLot(parkingLot);
				slot.setStatus(Status.AVAILABLE);
				
				if(carCounter < car) {
					slot.setType(Type.CAR);
					carCounter++;
				}else if(bikeCounter < bike) {
					slot.setType(Type.BIKE);
					bikeCounter++;
				}else {
					slot.setType(Type.TRUCK);
				}
				slots.add(slot);
				
			}
			parkingSlotService.addAll(slots);
			log.info("Created {} slots for parking lot: {}", totalSlots, parkingLot.getName());
			return parkingLot;
			
		}catch(Exception e) {
			log.error("Error saving parking lot {}",e);
			throw new ParkingLotException("Error saving parking lot");
		}
	}
	
	
	@Override
	public ParkingLot deleteParkingLot(ParkingLot parkingLot) throws ParkingLotException {
		log.debug("deleteParkingLot has been called");
		
		try {
			Optional<ParkingLot> opt = parkingLotRepo.findById(parkingLot.getParkingLotId());
			if(opt.isEmpty()) {
				throw new ParkingLotException("parking lot not found");
			}
			
			parkingLotRepo.delete(parkingLot);
			return parkingLot;
		}catch(Exception e) {
			log.error("Error deleting parking lot {}",e);
			throw new ParkingLotException("Error deleting parking lot");
		}
	}
	
	
	@Override
	public ParkingLot updateParkingLot(ParkingLot parkingLot) throws ParkingLotException {
		
		try {
			Optional<ParkingLot> opt = parkingLotRepo.findById(parkingLot.getParkingLotId());
			if(opt.isEmpty()) {
				throw new ParkingLotException("parking lot not found");
			}	
			ParkingLot oldParkingLot = opt.get();
			oldParkingLot.setAddress(parkingLot.getAddress());
			oldParkingLot.setName(parkingLot.getName());
			
			return parkingLotRepo.save(oldParkingLot);
		}catch(Exception e) {
			log.error("Error updating parking lot , {}" , e);
			throw new ParkingLotException("Error updating parking lot");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
