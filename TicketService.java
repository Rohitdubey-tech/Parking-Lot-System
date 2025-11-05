package com.sushant.parkingSystem.service;

import com.sushant.parkingSystem.model.Ticket;

public interface TicketService {

	Ticket addTicket(Ticket ticket);
	void releaseExpiredTickets();
	Ticket findActiveByVehicleId(Long vehicleId);

}