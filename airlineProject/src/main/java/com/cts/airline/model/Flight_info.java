package com.cts.airline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flight_info")
public class Flight_info {
	
	@Id
	@GeneratedValue
	private int flightInfoid;
	private String flightNumber;
	private String flightType;
	private int numberofSeats;
	
	public Flight_info() {
		// TODO Auto-generated constructor stub
	}
	
	public Flight_info(String flightNumber, String flightType, int numberofSeats) {
		this.flightNumber = flightNumber;
		this.flightType = flightType;
		this.numberofSeats = numberofSeats;
	}
	
	public int getFlightInfoId() {
		return flightInfoid;
	}

	public void setFlightInfoId(int flightInfoid) {
		this.flightInfoid = flightInfoid;
	}
	
	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightType() {
		return flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

	public int getNumberofSeats() {
		return numberofSeats;
	}

	public void setNumberOfSeats(int numberofSeats) {
		this.numberofSeats = numberofSeats;
	}
}
