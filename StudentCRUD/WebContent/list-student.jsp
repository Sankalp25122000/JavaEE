<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Students</title>
</head>
<body>
<form action = "StudentController" method = "GET">
<input type = "text" name = "name"/>
<input type = "hidden" name= "command" value = "SEARCH"/>
<button type = "submit">Search by User Name</button>
</form>
	<table border="1">
		<tr>
			<th>Sr. No.</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:set var = "count" value = "0" scope = "page"/>
		<c:forEach var="student" items="${students}">
		<c:url var = "count" value = "${count + 1 }" scope ="page"/>
			<c:url var="updateLink" value="StudentController">
				<c:param name="command" value="LOAD" />
				<c:param name="studentId" value="${student.id }" />
			</c:url>
			<c:url var="deleteLink" value="StudentController">
				<c:param name="command" value="DELETE" />
				<c:param name="studentId" value="${student.id }" />
			</c:url>
			<tr>
				<td>${count}</td>
				<td>${student.firstName}</td>
				<td>${student.lastName}</td>
				<td>${student.email}</td>
				<td>
					<button onclick="window.location.href='${updateLink}'">Update</button>
				<td>
					<button onclick="window.location.href='${deleteLink}'">Delete</button>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br> Add new Student :
	<button onclick="window.location.href ='add-student.jsp'">Add</button>
</body>
</html>