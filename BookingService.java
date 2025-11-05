package com.sushant.parkingSystem.service;

import org.springframework.security.core.Authentication;

import com.sushant.parkingSystem.dto.BookingRequest;

public interface BookingService {

	BookingRequest book(BookingRequest req,Authentication auth);

}