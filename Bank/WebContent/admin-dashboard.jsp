<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
  <br><br>
  <center>
  <div class="card text-bg-primary mb-3" style="max-width: 45rem";   >
   <center class=><h1 class="text-Seconday">Admin Dashboard</h1></center>
   <br>

   <hr><br>
   <form action="AdminController">
  <center>
     <button type="submit" class="btn btn-secondary btn-lg" name="command" value="userDetail">User Information</button><br><br>
         <button type="submit" class="btn btn-secondary btn-lg" name="command" value="userTransaction">Transactions Details</button><br><br>
         <a href="LogoutController" class="btn btn-outline-danger w-50">Logout</a> 
  
  </center>
  </form>
</div>
  </center>
</body>
</html>