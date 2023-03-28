<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ToDo's List</title>
</head>
<body>
	<h1>ToDoList</h1>
	<form action="todos.jsp" method="POST">
		<input type="text" name="Tasks" />
		<button type="submit">ADD</button>
	</form>
	<%--  <% session.removeValue("todoList"); %>   --%>
	<%
		List<String> items = (List<String>) session.getAttribute("todoList");

	if (items == null) {
		items = new ArrayList<>();
	}
	String tasks = request.getParameter("Tasks");
	if (tasks != null && tasks !="" && !items.contains(tasks)) {
		items.add(tasks);
		session.setAttribute("todoList", items);
	}
	%>
	<%
		for (String x : items) {
		out.println("<h4>" + x + "</h4>");
	}
	%>




</body>
</html>