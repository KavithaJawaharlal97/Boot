package com.cts.airline;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.airline.controller.HomeController;
import com.cts.airline.model.Booking_record;
import com.cts.airline.service.FlightCrudOperationsService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext ac = SpringApplication.run(HomeController.class, args);
		FlightCrudOperationsService ps = ac.getBean(FlightCrudOperationsService.class);
/*
	System.out.println("Write a class to retrive all indigo flights on 21st august 2020");

		ps.findByProductName("Indigo", LocalDate.of(2020, 8, 21)).forEach(flight -> {
			System.out.println("flight ID:: " + flight.getId() + " and flight number :: " + flight.getFlightNumber());
			System.out.println("------------------------------------");
		});

		System.out.println("Write a class to retrive all  flights leaving from delhi on 21st august 2020");

		ps.findByOriginName("DELHI", LocalDate.of(2020, 8, 21)).forEach(flight -> {
			System.out.println("flight ID:: " + flight.getId() + " and flight number :: " + flight.getFlightNumber());
			System.out.println("------------------------------------");
		});*/
	/*


	System.out.println("Write a class to retrive all  flights flying between delhi to chennai on 21st august 2020");
	
	ps.findByOriginAndFlightName("DELHI", LocalDate.of(2020, 8, 21),"CHENNAI").forEach(flight -> {
		System.out.println("flight ID:: " + flight.getId() + " and flight number :: " + flight.getFlightNumber() + "flight origin:: " + flight.getOrigin()+ "flight destination:: " + flight.getDestination()+ "flight time:: " + flight.getDuration()+"fare amount::"+flight.getFare().getFare()+"inventory count::"+flight.getInventory().getCount());
	});
	
	System.out.println("Write a class to search for flights with combination of flight number and origin and destination");
	
	ps.findByOriginAndFlightNumber("DELHI", "AI-840","CHENNAI").forEach(flight -> {
		System.out.println("flight ID:: " + flight.getId() + " and flight number :: " + flight.getFlightNumber() + " flight origin:: " + flight.getOrigin()+ " flight destination:: " + flight.getDestination()+ " flight time:: " + flight.getDuration());
		System.out.println(" fare details::"+flight.getFare()+" inventory count::"+flight.getInventory());
	});*/
/*	System.out.println("Write a class to search for flights with combination of flight number and origin and destination");
	
	ps.findByOriginAndFlightNumber(LocalDate.of(2020, 8, 21), "AI-850",LocalTime.of(1, 15)).forEach(flight -> {
		System.out.println("flight ID:: " + flight.getId() + " and flight number :: " + flight.getFlightNumber() + " flight origin:: " + flight.getOrigin()+ " flight destination:: " + flight.getDestination()+ " flight time:: " + flight.getFlightTime()+ " flight duration :: "+flight.getDuration());
		System.out.println(" fare details::"+flight.getFare()+" inventory count::"+flight.getInventory());
	});
	
	Fare fa = new Fare ("INR",4500);
	Inventory i = new Inventory (100);
	Flight_info fi = new Flight_info("AI-890","Airbus",140);
	Flight f = new Flight ("CHENNAI","2hrs 10mins",LocalDate.of(2020, 8, 22),"AI-890",LocalTime.of(6, 0, 0),"PUNE",fa,fi,i);
	
	Fare fa1 = new Fare ("INR",4500);
	Inventory i1 = new Inventory (100);
	Flight_info fi1 = new Flight_info("AI-891","Airbus",140);
	Flight f1 = new Flight ("CHENNAI","2hrs 12mins",LocalDate.of(2020, 8, 22),"AI-891",LocalTime.of(8, 15, 0),"PUNE",fa1,fi1,i1);
	
	Fare fa2 = new Fare ("INR",4500);
	Inventory i2 = new Inventory (100);
	Flight_info fi2 = new Flight_info("AI-892","Airbus",140);
	Flight f2 = new Flight ("CHENNAI","2hrs 15mins",LocalDate.of(2020, 8, 22),"AI-892",LocalTime.of(10, 30, 0),"PUNE",fa2,fi2,i2);
	
	Fare fa3 = new Fare ("INR",4500);
	Inventory i3 = new Inventory (100);
	Flight_info fi3 = new Flight_info("AI-893","Airbus",140);
	Flight f3 = new Flight ("CHENNAI","1hrs 10mins",LocalDate.of(2020, 8, 22),"AI-893",LocalTime.of(12, 45, 0),"PUNE",fa3,fi3,i3);
	
	Fare fa4 = new Fare ("INR",4500);
	Inventory i4 = new Inventory (100);
	Flight_info fi4 = new Flight_info("AI-894","Airbus",140);
	Flight f4 = new Flight ("CHENNAI","1hrs 30mins",LocalDate.of(2020, 8, 22),"AI-894",LocalTime.of(2, 0, 0),"PUNE",fa4,fi4,i4);
	
	Fare fa5 = new Fare ("INR",4500);
	Inventory i5 = new Inventory (100);
	Flight_info fi5 = new Flight_info("AI-895","Airbus",140);
	Flight f5 = new Flight ("CHENNAI","2hrs 10mins",LocalDate.of(2020, 8, 22),"AI-895",LocalTime.of(3, 30, 0),"PUNE",fa5,fi5,i5);
	
	//ps.save(f);
	//ps.save(f1);
	//ps.save(f2);
	//ps.save(f3);
	ps.save(f4);
	ps.save(f5);
	ps.findByOriginAndFlightName("PUNE", LocalDate.of(2020, 8, 22),"CHENNAI").forEach(flight -> {
		System.out.println("flight ID:: " + flight.getId() + " and flight number :: " + flight.getFlightNumber() + "flight origin:: " + flight.getOrigin()+ "flight destination:: " + flight.getDestination()+ "flight time:: " + flight.getDuration()+"fare amount::"+flight.getFare().getFare()+"inventory count::"+flight.getInventory().getCount());
	});
	List<Flight> f6 = new ArrayList<Flight>();
	f6.add(f);
	f6.add(f1);
	f6.add(f2);
	f6.add(f3);
	f6.add(f4);
	f6.add(f5);
	ps.saveAll(f6).forEach(flight -> {
		System.out.println("flight ID:: " + flight.getId() + " and flight number :: " + flight.getFlightNumber() + " flight origin:: " + flight.getOrigin()+ " flight destination:: " + flight.getDestination()+ " flight time:: " + flight.getFlightTime()+ " flight duration :: "+flight.getDuration());
		System.out.println(" fare details::"+flight.getFare()+" inventory count::"+flight.getInventory());
	});
	*/
	/*Booking_record br = new Booking_record(LocalDateTime.now(),"HYDERABAD",	3500,LocalDate.of(2020, 8, 21),"AI-850",LocalTime.of(1, 15),"DELHI","Confirmed");
	ps.save(br);
	ps.updateInventory("DELHI", "HYDERABAD");
	*/
//	ps.updateSchedule("DELHI", "PUNE","6E-6686", LocalDate.of(2020,8,22),LocalDate.of(2020,8,21),"Indigo");
	}
}
