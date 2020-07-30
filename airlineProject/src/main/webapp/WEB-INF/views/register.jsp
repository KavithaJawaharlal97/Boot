<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>registerpage</title>
</head>
<body>
<form action="/adduser">
        Name : <input type="text" name="username" /><br>
        Password : <input type="password" name="password" /><br> 
        Email Address : <input type="text" name="email" /><br>
        mobile number : <input type="text" name="number" /> <br>
        gender :<input type="radio" id="male" name="gender" value="male"/>
		<label for="male">Male</label><br>
		<input type="radio" id="female" name="gender" value="female"/>
		<label for="female">Female</label><br>
      <a href="/adduser">
       <button>Register</button>
     </a>
     </form>
  </body>
</html>