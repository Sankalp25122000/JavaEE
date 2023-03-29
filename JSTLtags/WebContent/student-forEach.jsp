<%@page import="java.util.ArrayList"%>
<%@page import="com.aurionpro.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<Student> students = new ArrayList<Student>();
	students.add(new Student("Sankalp", 1, "san@gmail.com", true));
	students.add(new Student("Sameer", 2, "sam@gmail.com", true));
	students.add(new Student("Tejas", 3, "tej@gmail.com", false));
	students.add(new Student("Amogh", 4, "amo@gmail.com", true));
	pageContext.setAttribute("studentList", students);
	%>
	
	<table border = "1">
	<tr>
	<th>Name</th>
	<th>Roll Number</th>
	<th>Email</th>
	<th>Scholarship</th>
	</tr>
	<c:forEach var = "student" items = "${studentList }">
	<tr>
	<td>${student.name}</td>
	<td>${student.rollNo}</td>
	<td>${student.email}</td>
	<c:if test="${student.scholarship == true }">
	<td>yes</td>
	</c:if>
	<c:if test="${student.scholarship == false}">
	<td>No</td>
	</c:if>
	
	</tr>
	</c:forEach>
	</table>

</body>
</html>