<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>

<%ResultSet resultset =null;%>
<%ResultSet resultset1 =null;%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <!--<link rel="stylesheet" href="/resources/demos/style.css">-->
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <script>
        $(function () {
            $("#datepicker").datepicker( 
            		{dateFormat:"yy-mm-dd"
            		});
        });
    </script>
<title>search</title>
</head>
<body>
<a href="/login">Login</a>
<a href="/register">Register</a>
 <a href="/checkin">Check in</a>

<form id="search" action="searchresult" method="post">
<%
    try{
//Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/airlinedetails?user=rootSQL&password=Sql@1234");

       Statement statement = connection.createStatement() ;
	   resultset =statement.executeQuery("select distinct origin from flight") ;
	   

       Statement statement1 = connection.createStatement() ;
	   resultset1 =statement1.executeQuery("select distinct destination from flight") ;
%>


    <h1> Origin </h1>
        <select name = "origin">
        <%  while(resultset.next()){ %>
            <option><%= resultset.getString(1)%></option>
        <% } %>
        </select>
        
    <h1> Destination </h1>
        <select name = "destination">
        <%  while(resultset1.next()){ %>
            <option><%= resultset1.getString(1)%></option>
        <% } %>
        </select>    

<%
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>

<h1>
Date:  <input type="text" class="form-control" name="datepicker" id="datepicker" placeholder="Date" required=""/>
</h1>

	<a href="/searchresult">
       <button>Search</button>
     </a>
     
    
     </form>
</body>
</html>