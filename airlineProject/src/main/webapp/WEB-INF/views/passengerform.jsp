<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>passengerdetails</title>
</head>
<body>
<form action="/addpassenger">
        FirstName : <input type="text" name="firstname" /><br>
        LastName : <input type="text" name="lastname" /><br> 
        Email Address : <input type="text" name="email" /><br>
        mobile number : <input type="text" name="number" /> <br>
        gender :<input type="radio" id="male" name="gender" value="male"/>
		<label for="male">Male</label><br>
		<input type="radio" id="female" name="gender" value="female"/>
		<label for="female">Female</label><br>
      <a href="/addpassenger">
       <button>Book</button>
     </a>
     </form>
</body>
</html>