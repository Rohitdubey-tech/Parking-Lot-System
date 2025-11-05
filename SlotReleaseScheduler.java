package com.sushant.parkingSystem.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sushant.parkingSystem.service.TicketService;

@Component
@EnableScheduling
public class SlotReleaseScheduler {

    @Autowired
    private TicketService ticketService;

    @Scheduled(fixedRate = 60000) 
    public void releaseExpiredSlots() {
        ticketService.releaseExpiredTickets();
    }
}
