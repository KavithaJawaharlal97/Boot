package com.cts.airline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fare")
public class Fare {
	@Id
	@GeneratedValue
	private int fareId;
	private String currency;
	private double fare;

	public Fare() {
		// TODO Auto-generated constructor stub
	}

	public Fare(String currency,double fare) {
		this.currency = currency;
		this.fare = fare;
	}

	public int getFareId() {
		return fareId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public void setFareId(int fareId) {
		this.fareId = fareId;
	}

	@Override
	public String toString() {
		return "Fare [fareId=" + fareId + ", currency=" + currency + ", fare=" + fare + "]";
	}


}
