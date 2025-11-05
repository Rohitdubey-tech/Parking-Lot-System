package com.sushant.parkingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sushant.parkingSystem.dto.BookingRequest;
import com.sushant.parkingSystem.service.BookingService;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/book")
	public BookingRequest bookTicket(@RequestBody BookingRequest req , Authentication auth) {
		return bookingService.book(req,auth);
	}
}
