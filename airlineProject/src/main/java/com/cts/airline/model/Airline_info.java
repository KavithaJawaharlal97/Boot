package com.cts.airline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airline_info")
public class Airline_info {

	@Id
	@GeneratedValue
	private int airlineId;
	private String airlineLogo;
	private String nameOfAirline;
	
	public Airline_info(){
		
	}
	
	public Airline_info(String airlineLogo, String nameOfAirline) {
		super();
		this.airlineLogo = airlineLogo;
		this.nameOfAirline = nameOfAirline;
	}

	public int getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlineLogo() {
		return airlineLogo;
	}

	public void setAirlineLogo(String airlineLogo) {
		this.airlineLogo = airlineLogo;
	}

	public String getNameOfAirline() {
		return nameOfAirline;
	}

	public void setNameOfAirline(String nameOfAirline) {
		this.nameOfAirline = nameOfAirline;
	}
}
