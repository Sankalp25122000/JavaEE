<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>

<body>
  <div class="p-3 mb-2 bg-primary-subtle text-emphasis-primary">
    <form action="LoginController" method="POST">
    <center>
    
    <h1>SELECT YOUR LOGIN TYPE</h1>
      <input  class="form-check-input" type="radio" id="admin" name="userType" value="ADMIN" required>
      <label for="admin">ADMIN</label>
       <input class="form-check-input"  type="radio" id="user"
        name="userType" value="USER" required>
         <label for="user">USER</label>
      <br>
      <br>
      <label class="form-control" for="username">Email : </label> <br>
      <input  class="form-control" type="text" name="username" id="username" value="" required> 
      <br>
      <label  class="form-control" for="password">Password :</label> 
      <input  class="form-control" type="password" name="password" id="password" value="" required><br>
      <br>
      </center>
      <button  class="form-control" type="submit">Login</button>
      <c:out value="${msg}" />
    </form>
  </div>
</body>
</html>