package com.cts.airline.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.airline.model.Booking_record;
import com.cts.airline.model.Flight;

@Repository
public interface FlightDao extends JpaRepository<Flight, Integer> {
	
	public final static String FIND_BY_NAME_OF_AIRLINE = "FROM Flight f " +
            "WHERE f.flightInfoid IN (select fi.flightInfo from Flights_info fi "+
			"where fi.airlineInfo = (select ai.airlineId from Airline_info ai "+
            "where ai.nameOfAirline = :nameOfAirline))"+
			"And DATE(f.flightDate) = DATE (:flightDate)";
	
	public final static String FIND_BY_ORIGIN = "FROM Flight " +
            "where origin = :origin "+
			"And DATE(flightDate) = DATE (:flightDate)";
	
	public final static String FIND_BY_ORIGIN_DESTINATION_FLIGHTDATE = "select f FROM Flight f "+
	"left join f.fare fa " +
	"left join f.inventory i " +
	"where f.origin = :origin "+
	"And DATE(f.flightDate) = DATE (:flightDate) "+
	"and f.destination = :destination "+
	"order by fare asc";

	public final static String FIND_BY_ORIGIN_NUMBER_DESTINATION = "select f FROM Flight f "+
	"left join f.fare fa " +
	"left join f.inventory i " +
	"where DATE(f.flightDate) = DATE (:flightDate) "+
	"And f.flightNumber = :flightNumber "+
	"and f.flightTime = :flightTime ";
	
	public final static String decInventory = "update Inventory i set i.count = i.count-2"+
	" where i.invId = (select f.inventory from Flight f"
	+ " where f.origin = :origin"
	+ " And f.destination = :destination)";
	
	public final static String updateSchedule = "update Flight f set DATE(f.flightDate) = DATE (:newDate)"+
	 " where f.origin = :origin"+
	 " And f.destination = :destination"+
	"And f.flightNumber = :flightNumber "+
	"And f.flightDate = :flightDate"+
	" And f.flightInfoid = (select fi.flightInfo from Flights_info fi "+
	"where fi.airlineInfo = (select ai.airlineId from Airline_info ai "+
     "where ai.nameOfAirline = :nameOfAirline))";

	//List<Flight> saveAll(List<Flight> flights);

	@Query(value = FIND_BY_NAME_OF_AIRLINE)
	List<Flight> findByNameOfAirlineAndFlightDate(@Param("nameOfAirline") String nameOfAirline, @Param("flightDate") LocalDate flightDate);
	
	@Query(value = FIND_BY_ORIGIN)
	List<Flight> findByOriginAndFlightDate(@Param("origin") String origin, @Param("flightDate") LocalDate flightDate);
	
	@Query(value = FIND_BY_ORIGIN_DESTINATION_FLIGHTDATE)
	List<Flight> findByOriginAndFlightDateAndDestination(@Param("origin") String origin, @Param("flightDate") LocalDate flightDate,@Param("destination") String destination );
	
	//@Query(value = FIND_BY_ORIGIN_NUMBER_DESTINATION)
	//List<Flight> findByOriginAndFlightNumberAndDestination(@Param("origin") String origin, @Param("flightNumber") String flightNumber,@Param("destination") String destination );
	
	@Query(value = FIND_BY_ORIGIN_NUMBER_DESTINATION)
	List<Flight> findByOriginAndFlightNumberAndDestination(@Param("flightDate") LocalDate flightDate, @Param("flightNumber") String flightNumber,@Param("flightTime") LocalTime flightTime );
		
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = decInventory)
	public void updateInventory(@Param("origin") String origin,@Param("destination") String destination );
	
//	@Transactional
	//@Modifying(clearAutomatically = true)
//	@Query(value = updateSchedule)
	//public void updateSchedule(@Param("origin") String origin,@Param("destination") String destination, @Param("flightNumber") String flightNumber,@Param("flightDate") LocalDate flightDate,/*@Param("flightTime") LocalTime flightTime,*/@Param("newDate") LocalDate newDate/*,@Param("newTime") LocalTime newTime*/,@Param("nameOfAirline") String nameOfAirline );
	
	
//	@Query(value = "from Flight")
  //  public List<Flight> listOrigin();
	@Query(value= "select u.username from UserDetails u where u.username=:username and u.password = :password")
	public String checkuser(@Param("username")String username,@Param("password")String password);
	
	
	@Modifying
	@Transactional
	@Query(value= "insert into UserDetails(username,password,id) values(:username,:password,1)",nativeQuery=true)
	public void updateuser(@Param("username")String username,@Param("password")String password);
	
	@Modifying
	@Transactional
	@Query(value= "insert into Booking_record(booking_id,booking_date,destination, fare,flight_date,flight_number,flight_time,origin,status) values (:bookingid,:bookingDate,:destination,:fare,:flightDate,:flightNumber,:flightTime,:origin,:status)",nativeQuery=true)
	public void updatebooking(@Param("bookingid") int bookingid,@Param("bookingDate") LocalDateTime bookingDate,@Param("destination") String destination,@Param("flightDate") LocalDate flightDate,@Param("flightTime") LocalTime flightTime,@Param("flightNumber") String flightNumber,@Param("origin") String origin,@Param("fare") double fare,@Param("status") String status);
	
	@Modifying
	@Transactional
	@Query(value= "insert into Passenger(passenger_id,email_address,first_name,gender,last_name,mobile_number,booking_id) values (:passengerid,:email,:firstname,:gender,:lastname,:number,:bookingid)",nativeQuery=true)
	public void addpassenger(@Param("passengerid")int passengerid,@Param("email") String email,@Param("firstname") String firstname,@Param("gender") String gender,@Param("lastname") String lastname,@Param("number") String number,@Param("bookingid") int bookingid);
	
	@Query(value= "from Booking_record b where b.bookingId=:bid")
	public List<Booking_record> getbookid(@Param("bid") int bid);
	
	void deleteById(int id);
	
	
	
}
