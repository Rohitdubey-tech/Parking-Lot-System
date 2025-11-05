package com.sushant.parkingSystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ParkingLot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long parkingLotId;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String address;
	
	@Column(nullable=false)
	private String city;
	
	@Column(nullable=false)
	private String state;
	
	@Column(nullable=false)
	private Integer totalParkingSlots;
	

	public ParkingLot() {
		super();
	}

	public ParkingLot(Long parkingLotId, String name, String address, String city, String state, Integer totalParkingSlots) {
		super();
		this.parkingLotId = parkingLotId;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.totalParkingSlots = totalParkingSlots;
	}

	public Long getParkingLotId() {
		return parkingLotId;
	}

	public void setParkingLotId(Long parkingLotId) {
		this.parkingLotId = parkingLotId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getTotalParkingSlots() {
		return totalParkingSlots;
	}

	public void setTotalParkingSlots(Integer totalParkingSlots) {
		this.totalParkingSlots = totalParkingSlots;
	}

	@Override
	public String toString() {
		return "ParkingLot [parkingLotId=" + parkingLotId + ", name=" + name + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", totalFloors=" + totalParkingSlots + "]";
	}
}
