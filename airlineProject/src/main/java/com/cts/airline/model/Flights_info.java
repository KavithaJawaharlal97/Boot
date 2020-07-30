package com.cts.airline.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "flights_info")
public class Flights_info implements Serializable  {
	
	@Id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "flightInfoid")
	private Flight_info flightInfo;
	
	@Id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "airlineId")
	private Airline_info airlineInfo;
	
	public Flights_info(){
		
	}

	public Flights_info(Flight_info flightInfo, Airline_info airlineInfo) {
		super();
		this.flightInfo = flightInfo;
		this.airlineInfo = airlineInfo;
	}

	public Flight_info getFlightInfo() {
		return flightInfo;
	}

	public void setFlightInfo(Flight_info flightInfo) {
		this.flightInfo = flightInfo;
	}

	public Airline_info getAirlineInfo() {
		return airlineInfo;
	}

	public void setAirlineId(Airline_info airlineInfo) {
		this.airlineInfo = airlineInfo;
	}

}
