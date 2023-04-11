<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://kit.fontawesome.com/c102305e9c.js"
	crossorigin="anonymous"></script>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
	
<meta charset="ISO-8859-1">
<title>List of Users</title>
</head>
<body>

	<br><br>
	</form>

	<div class="container-fluid">
		<center>
			<h1>User Details</h1>
		</center>
		<br> <br>
		<form action="AdminController">
			<input type="hidden" name="command" value="search"> <input
				type="text" placeholder="User id " name="search" required>
			<span><input type="submit" value="Search" class="btn-primary-a"></span>
			<c:out value="${msg1}"></c:out>
		</form>

		<!-- <hr> -->
		<table
			class="table table-striped  table-hover table-light table-borderless">

			<tr>
				<th>User Id</th>
				<th>Fname</th>
				<th>Lname</th>
				<th>Username</th>
				<th>Password</th>
				<th>Balance</th>
				<!-- <th>Add</th> -->
				<th>Delete</th>
			</tr>

			<%-- <c:if test="${searchList == null}">
			<p>No records found</p>
			</c:if> --%>

			<c:forEach var="user" items="${listUser}">

				<c:url var="addLink" value="AdminController">
					<c:param name="command" value="add"></c:param>
					<c:param name="id" value="${user.userId}"></c:param>
				</c:url>

				<c:url var="deleteLink" value="AdminController">
					<c:param name="command" value="delete"></c:param>
					<c:param name="id" value="${user.userId}"></c:param>
				</c:url>


				<tr>
					<td>${user.userId}</td>
					<td>${user.fname}</td>
					<td>${user.lname}</td>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td>${user.balance}</td>

					<td><a href="${deleteLink}">
							<button type="button" class="btn btn-link">
								<i class="fa fa-trash-o" style="font-size: 24px; color: #004880"></i>
							</button>
					</a></td>
				</tr>
			</c:forEach>

			<hr>
		</table>
		<hr>

		<input type="button" value="Add User" class="btn btn-primary-a"
			onclick="window.location.href='add-user.jsp';">
		<center>
			<a href="LogoutController" class="btn btn-outline-c w-50">Logout</a>
			<hr>
		</center>
</body>
</html>