package com.sushant.parkingSystem.model;


import java.time.LocalDateTime;

import com.sushant.parkingSystem.enums.TicketStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketId;
	
	@Column(nullable=false)
	private Long vehicleId;
	
	@Column(nullable=false)
	private Long parkingSlotId;
	
	@Column(nullable=false)
	private LocalDateTime startTime;
	
	@Column(nullable=false)
	private LocalDateTime endTime;
	
	@Column(nullable=false)
	private Double amount;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private TicketStatus ticketStatus;

	public Ticket() {
		super();
	}

	public Ticket( Long vehicleId, Long parkingSlotId, LocalDateTime startTime, LocalDateTime endTime,
			Double amount, TicketStatus ticketStatus) {
		super();
		this.vehicleId = vehicleId;
		this.parkingSlotId = parkingSlotId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.amount = amount;
		this.ticketStatus = ticketStatus;
	}
	
	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Long getParkingSlotId() {
		return parkingSlotId;
	}

	public void setParkingSlotId(Long parkingSlotId) {
		this.parkingSlotId = parkingSlotId;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", vehicle=" + vehicleId + ", parkingSlot=" + parkingSlotId + ", startTime="
				+ startTime + ", endTime=" + endTime + ", amount=" + amount + "]";
	}
}
