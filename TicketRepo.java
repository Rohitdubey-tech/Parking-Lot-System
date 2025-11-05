package com.sushant.parkingSystem.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sushant.parkingSystem.model.Ticket;

@Repository
public interface TicketRepo extends JpaRepository<Ticket,Long>{
	
	@Query(value="select * from parking_lot_system.ticket where vehicle_id = :vehicleId and ticket_Status='ACTIVE'" , nativeQuery=true)
	public Ticket findByVehicleIdAndActiveStatus(Long vehicleId);
	
	@Query(value="select * from parking_lot_system.ticket where end_time<=:currentTime and ticket_Status='ACTIVE'" , nativeQuery=true)
	public List<Ticket> findExpiredTickets(LocalDateTime currentTime);
}
