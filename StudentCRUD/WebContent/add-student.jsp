<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="StudentController" method="get">
		<input type="hidden" name="command" value="ADD"> First Name: <input
			type="text" name="firstName" /> Last Name: <input type="text"
			name="lastName" /> Email: <input type="text" name="email" />
		<button type="submit">Add Student Info</button>
	</form>
</body>
</html>