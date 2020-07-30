<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>displaybookingdetails</title>
<link rel="stylesheet" type="text/css"
 href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
</head>
<body>
</head>
<body>
 <div class="starter-template">
<table border="2" cellpadding="10" bordercolor="blue">
    <tr>
     <th>Destination</th>
     <th>Booking Date</th>
     <th>Flight Date</th>
     <th>Flight Time</th>
     <th>Flight Number</th>
     <th>Origin</th>
     <th>fare amount</th>
     <th>seat number</th>
    </tr>
    <c:forEach var="flight" items="${details}">
     <tr>
      <td>${flight.destination}</td>
      <td>${flight.bookingDate}</td>
      <td>${flight.flightDate}</td>
      <td>${flight.flightTime}</td>
      <td>${flight.flightNumber}</td>
      <td>${flight.origin}</td>
      <td>${flight.fare}</td>
      <td>${seatid}</td>
     </tr>
    </c:forEach>
   </table>
  </div>
</body>
</html>