<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
<c:set var="String" value="Hello GUYS!!"/>  
  
<c:if test="${fn:contains(String, 'Guys!!')}">  
   <p>Found 'Guys!!' string<p>  
</c:if>  
  
<c:if test="${fn:contains(String, 'GUYS!!')}">  
   <p>Found GUYS!! string<p>  
</c:if>
<c:if test="${fn:endsWith(String, 'Guys!!')}">  
   <p>String ends with Guys!!<p>  
</c:if>
  
</body>
</html>