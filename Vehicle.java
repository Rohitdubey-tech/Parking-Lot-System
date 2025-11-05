package com.sushant.parkingSystem.model;

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
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vehicleId;
	
	@Column(nullable=false,unique=true)
	private String plateNumber;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Type type;
	
	
	public Vehicle() {
		super();
	}

	public Vehicle( String plateNumber, User user, Type type) {
		super();
		this.plateNumber = plateNumber;
		this.user = user;
		this.type = type;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", plateNumber=" + plateNumber + ", user=" + user + ", type=" + type
				+ "]";
	}
}
