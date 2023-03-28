<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<%-- <%
  String firstName = request.getParameter("first_name");
String lastName = request.getParameter("last_name");

%> --%>
<%-- <h1>Hello <%= firstName+ " "+lastName %> </h1> --%>

<h1>Hello ${param.first_name} ${param.last_name0}</h1>
<h1>Your Gender is ${param.gender}</h1>
<h1>Your favorite subjects is/are </h1>
<% 
		String[] values = request.getParameterValues("subject");
		for(String x : values ) {
			out.println("<h2>"+x+"</h2>");
		}
	%>
<h1>You are in ${param.year }</h1>

</body>
</html>
