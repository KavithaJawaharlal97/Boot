package com.cts.airline.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "passenger")
public class Passenger implements Serializable{

	@Id
	@GeneratedValue
	private int passengerId;
	private String emailAddress; 
	private String firstName; 
	private String gender; 
	private String lastName; 
	private int mobileNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookingId")
	private Booking_record bookingRecord;

	public Passenger(){
		
	}

	public Passenger(String emailAddress, String firstName, String gender, String lastName, int mobileNumber,
			Booking_record bookingRecord) {

		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.gender = gender;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.bookingRecord = bookingRecord;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Booking_record getBookingRecord() {
		return bookingRecord;
	}

	public void setBookingRecord(Booking_record bookingRecord) {
		this.bookingRecord = bookingRecord;
	}
	
}
