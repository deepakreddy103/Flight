<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Flight</title>
</head>
<body>
	<h2>Find Flight</h2>
	<form action="findFlights" method="post">
			From: <input type="text" name="from"/>
			To: <input type="text" name="to"/>
			Departure Date: <input type="text" name="departureDate"/>
			<input type="Submit" value="search"/>
	</form>
</body>
</html>