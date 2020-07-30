package com.cts.airline.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.cts.airline.model.Booking_record;
import com.cts.airline.model.Flight;

public interface FlightCrudOperationsService {

	Flight save(Flight flight);
	Booking_record save(Booking_record bookingRecord);

	List<Flight> saveAll(List<Flight> flights);

	List<Flight> findAll();

	Flight findById(int id);

	void deleteById(int id);
	List<Flight> findProductByNameLike(String name);
	List<Flight> findByProductName(String nameOfAirline,LocalDate flightDate);
	List<Flight> findByOriginName(String origin,LocalDate flightDate);
	List<Flight> findByOriginAndFlightName(String origin,LocalDate flightDate,String destination);
	//List<Flight> findByOriginAndFlightNumber(String origin,String flightNumber,String destination);
	List<Flight> findByOriginAndFlightNumber(LocalDate flightDate,String flightNumber,LocalTime flightTime);
	void updateInventory(String origin,String destination);
	//void updateSchedule(String origin,String destination,String flightNumber,LocalDate flightDate,LocalDate newDate,String nameOfAirline);
	String checkuser(String username,String password);
	void updateuser(String username,String password);
	public void updatebooking(int bookingid,LocalDateTime bookingDate,String destination,LocalDate flightDate,LocalTime flightTime,String flightNumber,String origin,double fare,String status);
	public void addpassenger(int passengerid,String email,String fname,String gender,String lname,String number,int bookingid);
	public List<Booking_record> getbookid(int bookingId);

}
