package com.sushant.parkingSystem.service;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sushant.parkingSystem.enums.Status;
import com.sushant.parkingSystem.enums.TicketStatus;
import com.sushant.parkingSystem.model.ParkingSlot;
import com.sushant.parkingSystem.model.Ticket;
import com.sushant.parkingSystem.repo.TicketRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	TicketRepo ticketRepo;
	
	@Autowired
	ParkingSlotService parkingSlotService;
	
	@Override
	public Ticket addTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}

	@Override
	public void releaseExpiredTickets() {
		List<Ticket> expired = ticketRepo.findExpiredTickets(LocalDateTime.now());
		for(Ticket ticket:expired) {
			ParkingSlot slot = parkingSlotService.findOne(ticket.getParkingSlotId());
			slot.setStatus(Status.AVAILABLE);
			ticket.setTicketStatus(TicketStatus.COMPLETED);
			parkingSlotService.addParkingSlot(slot);
			ticketRepo.save(ticket);
		}
	}

	@Override
	public Ticket findActiveByVehicleId(Long vehicleId) {
		return ticketRepo.findByVehicleIdAndActiveStatus(vehicleId);
	}
	
}










































