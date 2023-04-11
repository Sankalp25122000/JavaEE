<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://kit.fontawesome.com/c102305e9c.js"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
	
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body>
<br>
	<form action="AdminController" name="myform" method="post" >
	<div class="container p-3 my-3 border  bg-light text-dark ">
		<center class=>
			<h1 class="text-Seconday" >Add New User</h1>
		</center>
		<hr>
		
		<label for="user_id">User Id: </label> <input type="number" name="userId" class="form-control" id="userId" required><br>
		<label for="fname">First Name : </label> <input type="text" name="fname" class="form-control" id="fname" required ><br>
		<label for="lname">Last Name : </label> <input type="text" name="lname" class="form-control" id="lname" ><br>
		<label for="username">Username  : </label> <input type="text" name="username" class="form-control" id="username"><br>
		<label for="password">Password : </label> <input type="password" name="password" class="form-control" id="password" ><br>		
	    <label for="balance">Balance : </label> <input type="number" name="balance" class="form-control" id="balance" ><br>
		
		<center>
		<br> <input type="hidden" name="command" value="add"> 
		<input type="submit" class="btn btn-primary w-50" value="submit"></center> <br>
		
	</div>
	</form>
<br>
</body>

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</html>