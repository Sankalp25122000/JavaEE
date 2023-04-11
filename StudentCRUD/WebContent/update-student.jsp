<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="StudentController" method="GET">
		<input type="hidden" name="command" value="UPDATE" /> <input
			type="hidden" name="student_id" value="${theStudent.id}" /> First
		name <input type="text" name="first_name"
			value="${theStudent.firstName}" /> <br>
		<br> Last name <input type="text" name="last_name"
			value="${theStudent.lastName}" /> <br>
		<br> email <input type="text" name="email"
			value="${theStudent.email}" /> <br>
		<br>
		<button type="submit">Update Student</button>
	</form>
</body>
</html>