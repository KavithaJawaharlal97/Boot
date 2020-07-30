package com.cts.airline.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class Flight {

	@Id
	@GeneratedValue
	private int id;
	private String destination;
	private String duration;
	private LocalDate flightDate;
	private String flightNumber;
	
	private LocalTime flightTime;
	private String origin;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fareId")
	private Fare fare;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "flightInfoid")
	private Flight_info flightInfoid;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "invId")
	private Inventory inventory;
	

	public Flight() {
		// TODO Auto-generated constructor stub
	}

	public Flight(String destination, String duration, LocalDate flightDate, String flightNumber,
			LocalTime flightTime, String origin, Fare fare, Flight_info flightInfoid, Inventory inventory) {
		this.destination = destination;
		this.duration = duration;
		this.flightDate = flightDate;
		this.flightNumber = flightNumber;
		this.flightTime = flightTime;
		this.origin = origin;
		this.fare = fare;
		this.flightInfoid = flightInfoid;
		this.inventory = inventory;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}

	public LocalTime getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(LocalTime flightTime) {
		this.flightTime = flightTime;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Fare getFare() {
		return fare;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Flight_info getFlightInfoid() {
		return flightInfoid;
	}

	public void setFlightInfoid(Flight_info flightInfoid) {
		this.flightInfoid = flightInfoid;
	}

	public void setFare(Fare fare) {
		this.fare = fare;
	}
}
