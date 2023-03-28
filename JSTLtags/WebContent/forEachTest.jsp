<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
 String [] cities = {"Mumbai","Navi-Mumbai","Bangalore","Chennai"}; //implicit objects
pageContext.setAttribute("myCities", cities);
 
%>

<c:forEach var = "x" items = "${myCities}">
   ${x}<br>
</c:forEach>
</body>
</html>