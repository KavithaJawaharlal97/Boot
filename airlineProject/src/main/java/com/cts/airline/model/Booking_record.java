package com.cts.airline.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking_record")
public class Booking_record{

	@Id
	@GeneratedValue
	private int bookingId; 
	private LocalDateTime bookingDate; 
	private String destination; 
	private double fare; 
	private LocalDate flightDate;
	private String flightNumber; 
	private LocalTime  flightTime;
	private String origin; 
	private String status;
	
	public Booking_record(){
		
	}

	public Booking_record(LocalDateTime bookingDate, String destination, double fare, LocalDate flightDate,
			String flightNumber, LocalTime flightTime, String origin, String status) {
		this.bookingDate = bookingDate;
		this.destination = destination;
		this.fare = fare;
		this.flightDate = flightDate;
		this.flightNumber = flightNumber;
		this.flightTime = flightTime;
		this.origin = origin;
		this.status = status;
	}

	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public LocalDate getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public LocalTime getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(LocalTime flightTime) {
		this.flightTime = flightTime;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}