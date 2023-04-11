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
<title>Admin transactions Page</title>
</head>
<body>

  <br>
  <br>
  <div class="container-fluid">
    <center>
      <h1>Transaction Details</h1>
    </center>

    <form action="AdminController">
      <input type="hidden" name="command" value="searchadminpassbook">
  
      <input type="text" placeholder="Enter acc_no" name="searchadmin"
        required> <span><input type="submit" value="Search"
        class="btn-primary"></span>
        <c:out value="${msg2}"></c:out>
    </form>

    <hr>
    <table
      class="table table-striped  table-hover table-light table-borderless">

      <tr class="text-center">
        <!-- <th>Account No</th> -->

        <th>Transaction Id</th>
        <th>Acc No</th>

        
        <th>Transaction Type</th>
        <th>Transaction Date Time</th>
        <th>Amount</th>
     

      </tr>
      <c:forEach var="transactions" items="${listPassbook}">
        <tr class="text-center">
          <td>${transactions.transactionId}</td>
          <td>${transactions.accountNumber}</td>

          <td>${transactions.transactionType}</td>
          <td>${transactions.dateTime}</td>
          <td>${transactions.amount}</td>
          
<!--           	private int transactionId;
	private int accountNumber;
	private String transactionType;
	private String dateTime;
	private int amount;
 -->
        </tr>
      </c:forEach>
    </table>
  
</body>
</html>