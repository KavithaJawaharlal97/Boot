package com.cts.airline.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.airline.dao.BookingRecordDao;
import com.cts.airline.dao.FlightDao;
import com.cts.airline.model.Booking_record;
import com.cts.airline.model.Flight;

@Service
public class FlightServiceImpl implements FlightCrudOperationsService {

	@Autowired
	private FlightDao flightDao;
	
	@Autowired
	private BookingRecordDao<?> bookingrecordDao;
	

	@Override
	public Flight save(Flight flight) {
		// TODO Auto-generated method stub
		return (Flight) flightDao.save(flight);
	}
	
	@Override
	public Booking_record save(Booking_record br) {

		// TODO Auto-generated method stub
		return (Booking_record) bookingrecordDao.save(br);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Flight> saveAll(List<Flight> flights) {
		// TODO Auto-generated method stub
		return flightDao.saveAll(flights);
	}

	@Override
	public List<Flight> findAll() {
		// TODO Auto-generated method stub
		return flightDao.findAll();
	}

	@Override
	public Flight findById(int id) {
		return (Flight) flightDao.findById(id).orElse(null);
	}

	@Override
	public List<Flight> findByOriginName(String origin, LocalDate flightDate) {
		// TODO Auto-generated method stub
		return flightDao.findByOriginAndFlightDate(origin,flightDate);
	}
	
	@Override
	public List<Flight> findByOriginAndFlightName(String origin, LocalDate flightDate,String destination) {
		// TODO Auto-generated method stub
		return flightDao.findByOriginAndFlightDateAndDestination(origin,flightDate,destination);
	}
	
	@Override
	public List<Flight> findByOriginAndFlightNumber(LocalDate origin, String flightNumber,LocalTime destination) {
		// TODO Auto-generated method stub
		return flightDao.findByOriginAndFlightNumberAndDestination(origin,flightNumber,destination);
	}
	
	@Override
	public void deleteById(int id) {
		flightDao.deleteById(id);

	}
	
	@Override
	public String checkuser(String username,String password) {
		return flightDao.checkuser(username,password);

	}
	
	@Override
	public void updateuser(String username,String password) {
		 flightDao.updateuser(username,password);

	}

	@Override
	public void updatebooking(int bookingid,LocalDateTime bookingDate,String destination, LocalDate flightDate, LocalTime flightTime,
			String flightNumber, String origin, double fare,String status) {
		// TODO Auto-generated method stub
		flightDao.updatebooking(bookingid,bookingDate,destination, flightDate, flightTime, flightNumber, origin, fare,status);
	}

	@Override
	public void addpassenger(int passengerid,String email, String fname, String gender, String lname, String number, int bookingid) {
		// TODO Auto-generated method stub
		flightDao.addpassenger(passengerid,email, fname, gender, lname, number, bookingid);
	}
	

	@Override
	public List<Booking_record> getbookid(int bookingId) {
		// TODO Auto-generated method stub
		return flightDao.getbookid(bookingId);
	}

	@Override
	public List<Flight> findByProductName(String nameOfAirline,LocalDate flightDate) {
		// TODO Auto-generated method stub
		return flightDao.findByNameOfAirlineAndFlightDate(nameOfAirline,flightDate);
	}

	@Override
	public List<Flight> findProductByNameLike(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateInventory(String origin, String destination) {
		flightDao.updateInventory(origin,destination);

	}

//	@Override
	//public void updateSchedule(String origin, String destination, String flightNumber, LocalDate flightDate,LocalDate newDate,String nameOfAirline) {
//		flightDao.updateSchedule(origin,destination,flightNumber, flightDate,newDate,nameOfAirline);
	
	//}
	
}
