<%@page import="com.aurionpro.model.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Expression tags</h1>
 <h1>Todays date : <%= new java.util.Date() %></h1>
 <h2>Hello world in lower case<%= new String("Hello world in Lower Case ").toLowerCase() %></h2>
 <br>
 <h3>Scriplet tags</h3>
 <%
 for(int i = 1; i<= 10; i++){
	 out.println("i : "+i+"<br>");
 }
 %>
 <br>
 <h1>Declaration tags</h1>
 <%-- <%!String stringToUppercase(String str) {
		return str.toUpperCase();
	}%> --%>
<h2>Hello world in upper case : <%= new StringUtil().stringToUppercase("hello world") %></h2>
</body>
</html>