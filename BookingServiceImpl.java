package com.sushant.parkingSystem.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.sushant.parkingSystem.dto.BookingRequest;
import com.sushant.parkingSystem.enums.Status;
import com.sushant.parkingSystem.enums.TicketStatus;
import com.sushant.parkingSystem.model.ParkingSlot;
import com.sushant.parkingSystem.model.Ticket;
import com.sushant.parkingSystem.model.User;
import com.sushant.parkingSystem.model.Vehicle;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	TicketService ticketService;
	
	@Autowired
	ParkingSlotService parkingSlotService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	VehicleService vehicleService;
	
	@Override
	public BookingRequest book(BookingRequest req,Authentication auth) {
		
		ParkingSlot availParkingSlot = parkingSlotService.findOne(req.getParkingSlotId());
		if(availParkingSlot == null || availParkingSlot.getStatus() != Status.AVAILABLE) {
			req.setStatus("FAILED");
			req.setMessage("Parking not available");
			return req;
		}

		User currUser = userService.getCurrentUser(auth);
		
		Vehicle vehicle = vehicleService.getByPlateNumber(req.getPlateNumber());
		
		if(vehicle == null) {
			vehicle = new Vehicle(req.getPlateNumber(),currUser,availParkingSlot.getType());
			vehicle = vehicleService.addVehicle(vehicle);
		}else {
			Ticket isExisting = ticketService.findActiveByVehicleId(vehicle.getVehicleId());
			if(isExisting != null) {
				req.setStatus("FAILED");
				req.setMessage("Vehicle already booked until " + isExisting.getEndTime());
				return req;
			}
		}
		
		long duration = Duration.between(req.getStartTime(), req.getEndTime()).toMillis();
		double hours = duration / (1000.0 * 60 * 60);
		double amount = hours * 20;

		Ticket ticket = new Ticket(vehicle.getVehicleId(),availParkingSlot.getParkingSlotId(),req.getStartTime(),req.getEndTime(),amount,TicketStatus.ACTIVE);
		ticket = ticketService.addTicket(ticket);
		
		availParkingSlot.setStatus(Status.OCCUPIED);
		
		req.setUsername(currUser.getUsername());
		
		req.setVehicleId(vehicle.getVehicleId());
		req.setTicketId(ticket.getTicketId());
		req.setCharges(amount);
		req.setStatus("SUCCESS");
		req.setMessage("ticket booked successfully");
		
		return req;
		
	}
}

















