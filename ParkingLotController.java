package com.sushant.parkingSystem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sushant.parkingSystem.customException.ParkingLotException;
import com.sushant.parkingSystem.model.ParkingLot;
import com.sushant.parkingSystem.service.ParkingLotService;
import com.sushant.parkingSystem.service.ParkingLotServiceImpl;

@RestController
@RequestMapping("/api/parkinglot")
public class ParkingLotController {
	private static final Logger log = LoggerFactory.getLogger(ParkingLotServiceImpl.class);
	
	@Autowired
	ParkingLotService parkingLotService;
	
	@PostMapping("/admin")
	public ParkingLot addParkingLot(@RequestBody ParkingLot parkingLot) {
		ParkingLot added = null;
		try {
			added = parkingLotService.addParkingLot(parkingLot);
		}catch (Exception e) {
			log.error(e.getMessage());			
		}
		return added;
	}
	
	@GetMapping("/user")
	public List<ParkingLot> getParkingLot(){
		return parkingLotService.getAllParkingLot();
	}
	
	@GetMapping("/user/{id}")
	public ParkingLot getById(@PathVariable("id") Long id) {
		ParkingLot parkingLot = null;
		try {
			parkingLot = parkingLotService.getByid(id);
		} catch (ParkingLotException e) {
			log.error(e.getMessage());	
		}
		return parkingLot;
	}
	
	
	@DeleteMapping("/admin")
	public ParkingLot deleteParkingLot(@RequestBody ParkingLot parkingLot) {
		ParkingLot deleted = null;
		try {
			deleted = parkingLotService.deleteParkingLot(parkingLot);
		} catch (ParkingLotException e) {
			log.error(e.getMessage());	
		}
		return deleted;
	}
	
	
	@PutMapping("/admin")
	public ParkingLot updateParkingLot(@RequestBody ParkingLot parkingLot) {
		ParkingLot updated = null;
		try {
			updated = parkingLotService.updateParkingLot(parkingLot);
		} catch (ParkingLotException e) {
			log.error(e.getMessage());	
		}
		return updated;
	}
	
	
}




























