<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cookie Home</title>
</head>
<body>
<%
   String favCity = null;
   
 Cookie[] theCookies = request.getCookies();
 
 if(theCookies != null){
	 for(Cookie tempCookie : theCookies){
		 if("myCity".equals(tempCookie.getName())){
			 favCity = URLDecoder.decode(tempCookie.getValue(),"UTF-8");
			 break; 
		 }
	 }
 }
 
 if(favCity != null){
	 out.println("<h2>Favorite City "+favCity+ "</h2>");
 }
%>
<a href = "cookiesForm.jsp">Go to the City page</a>
</body>
</html>