package com.cts.airline.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking_details")
public class Booking_details implements Serializable{
	
	@Id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookingId")
	private Booking_record bookingRecord;
	
	/*@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumns({ 
	@JoinColumn(name = "passenger", referencedColumnName = "passengerId"),
	@JoinColumn(name = "bookingRecord", referencedColumnName = "bookingId")
	})
	private Passenger passenger;*/
	
	@Id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "passengerId")
	private Passenger passenger;
	
	public Booking_details(){}

	public Booking_details(Booking_record bookingRecord, Passenger passenger) {
		this.bookingRecord = bookingRecord;
		this.passenger = passenger;
	}

	public Booking_record getBookingRecord() {
		return bookingRecord;
	}

	public void setBookingRecord(Booking_record bookingRecord) {
		this.bookingRecord = bookingRecord;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

}
