package com.sushant.parkingSystem.model;

import com.sushant.parkingSystem.enums.Status;
import com.sushant.parkingSystem.enums.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class ParkingSlot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long parkingSlotId;
	
	@Column(nullable=false)
	private String slotNumber;
		
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Type type;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Status status;
	
	@ManyToOne
	@JoinColumn(name="parkingLotId")
	private ParkingLot parkingLot;

	public ParkingSlot() {
		super();
	}

	public ParkingSlot(Long parkingSlotId, String slotNumber, Type type, Status status, ParkingLot parkingLot) {
		super();
		this.parkingSlotId = parkingSlotId;
		this.slotNumber = slotNumber;
		this.type = type;
		this.status = status;
		this.parkingLot = parkingLot;
	}

	public Long getParkingSlotId() {
		return parkingSlotId;
	}

	public void setParkingSlotId(Long parkingSlotId) {
		this.parkingSlotId = parkingSlotId;
	}

	public String getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(String slotNumber) {
		this.slotNumber = slotNumber;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public ParkingLot getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	@Override
	public String toString() {
		return "ParkingSlot [parkingSlotId=" + parkingSlotId + ", slotNumber=" + slotNumber + ", type=" + type
				+ ", status=" + status + ", parkingLot=" + parkingLot + "]";
	}	
}
