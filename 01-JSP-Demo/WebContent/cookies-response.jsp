<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>City Response</title>
</head>
<body>

<%-- <h1>${param.city}</h1> --%>
<%
String favCity = request.getParameter("city");
Cookie theCookie = new Cookie("myCity",URLEncoder.encode(favCity,"UTF-8"));
theCookie.setMaxAge(60*60*24*365);
response.addCookie(theCookie);
%>
<a href = "cookie-home.jsp">Cookie Home</a>

</body>
</html>