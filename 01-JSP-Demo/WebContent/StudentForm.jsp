<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="student-response.jsp" method="GET">
		First Name : <input type="text" name="first_name" /> <br> Last
		Name : <input type="text" name="last_name>" /> <br> Gender <br>
		<input type="radio" id="male" name="gender" value="male">   <label
			for="male">Male</label><br>   <input type="radio" id="female"
			name="gender" value="female">   <label for="female">Female</label><br>
		  <input type="radio" id="other" name="gender" value="other">
		  <label for="other">Other</label> <br> Favourite subject : <br>
		<input type="checkbox" name="subject" value="java"> <label
			for="java"> Java</label><br> <input type="checkbox"
			name="subject" value="c++"> <label for="c++">c++</label><br>
		<input type="checkbox" name="subject" value="python"> <label
			for="python">python</label><br>
		<br> Year : <select name="year" id="cars">
			<option value="FY">FY</option>
			<option value="SY">SY</option>
			<option value="TY">TY</option>

		</select> <br>
		<button type="submit">Submit</button>
	</form>
</body>
</html>