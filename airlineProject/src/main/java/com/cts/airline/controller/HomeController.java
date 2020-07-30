package com.cts.airline.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.airline.dao.FlightDao;
import com.cts.airline.model.Flight;

@Controller
//@RestController
@Scope("session")
@EnableAutoConfiguration
@ComponentScan({"com.cts.airline"})
@EnableJpaRepositories("com.cts.airline.dao")
public class HomeController {

	@Autowired
	private FlightDao flightdao;
	HttpSession session= null;
	HttpServletRequest request = null;
	int bookingid=0;
	int passengerid=89;
	Model bid;

	@RequestMapping("/home")  
	public String hello()   
	{  
		return "flightsearch";
	}
	 @RequestMapping(value = "/items/{destination}/{flightDate}/{flightTime}/{flightNumber}/{origin}/{fare}")
	  public String getbooking(HttpServletRequest request,Model m,@PathVariable("destination") String destination,@PathVariable("flightDate") String flightDate,@PathVariable("flightTime") String flightTime,@PathVariable("flightNumber") String flightNumber,@PathVariable("origin") String origin,@PathVariable("fare") String fare){
	     
		 session=request.getSession(true);
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 LocalDateTime bookingDate = LocalDateTime.now();
			//convert String to LocalDate
			LocalDate localflightDate = LocalDate.parse(flightDate, formatter);
			LocalTime localflightTime = LocalTime.parse(flightTime,
		            DateTimeFormatter.ISO_LOCAL_TIME);
			double fared=Double.parseDouble(fare);
			String status = "CONFIRMED";
			if((String) session.getAttribute("Username")!=null)
			{
				
				flightdao.updatebooking(bookingid,bookingDate,destination,localflightDate, localflightTime, flightNumber, origin, fared,status);
				 bookingid++;
				 return "book";
			}
			else
				return "loginerror";
		 
	  }
	
	/*@RequestMapping(value="/book")  
	public String book(HttpServletRequest request)   
	{  
		
		session=request.getSession(true);
		
		if((String) session.getAttribute("Username")!=null)
			return "book";
		else
			return "loginerror";
	}*/
	
	@RequestMapping("/login")  
	public String login()   
	{  
		return "loginpage";
	}  
	
	@RequestMapping(value="/welcome")  
	public String welcome(@RequestParam("username") String username,@RequestParam("password") String password,Model m,HttpServletRequest request)   
	{  
		session=request.getSession(true);
		
		if(username.equals(flightdao.checkuser(username,password))){
		
			String msg = "Hello "+username;
			session.setAttribute("Username", username);
			session.setAttribute("Password", password);
			m.addAttribute("message",msg);
			return "welcome";
		}
		else		
			return "errorpage";
	}  
	
	@RequestMapping(value="/addpassenger")  
	public String addpass(@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname,@RequestParam("email") String emailAddress,@RequestParam("number") String mobileNumber,@RequestParam("gender") String gender,Model m,HttpServletRequest request)   
	{  

		flightdao.addpassenger(passengerid,emailAddress, firstname, gender, lastname, mobileNumber,bookingid-1);
		passengerid++;
		return "flightsearch";
	}  
	
	@RequestMapping("/register")  
	public String register()   
	{  
		return "register";
	}  
	@RequestMapping("/checkin")  
	public String checkin()   
	{  
		return "checkin";
	}  
	
	@RequestMapping("/displaydetails")  
	public String displaydetails(@RequestParam("bookid") String bookid,@RequestParam("seatid") String seatid,Model m)   
	{  
		int bid = Integer.parseInt(bookid);
		m.addAttribute("details",flightdao.getbookid(bid));
		m.addAttribute("seatid",seatid);
		return "displaydetails";
	}  
	@RequestMapping("/searchresult")  
	public String search(@RequestParam("origin") String origin,@RequestParam("destination") String destination,@RequestParam ("datepicker") String datepicker ,Model m)   
	{  
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		//convert String to LocalDate
		LocalDate localDate = LocalDate.parse(datepicker, formatter);
        m.addAttribute("flights", flightdao.findByOriginAndFlightDateAndDestination(origin, localDate, destination));
		return "displayTables";
	}  
	
	@PostMapping("/adduser")  
	public String adduser(@RequestParam("username") String username,@RequestParam("password") String password,Model m)   
	{  
		flightdao.updateuser(username, password);
		return "adduser";
	}  
	
	 @GetMapping("/flights")
	  List<Flight> all() {
	    return flightdao.findAll();
	  }
	
	 @DeleteMapping(value = "/flight/{id}")
	    public String deletePost(@PathVariable int id) {

	       flightdao.deleteById(id);
	       return "deleted";
	    }
	
}
