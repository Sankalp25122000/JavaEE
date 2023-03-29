<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>c-catch</title>
</head>
<body>
	<c:catch var="exceptionCatch">
		<%
			int x = 4 / 0;
		%>
	</c:catch>

	<c:if test="${exceptionCatch != null}">
		<p>Exception : ${exceptionCatch}</p>
		<p>Exception message : ${exceptionCatch.message}</p>
	</c:if>
</body>
</html>