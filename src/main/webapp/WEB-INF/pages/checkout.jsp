<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>COMP303 Assignment 2</title>
	<!-- Custom CSS -->
	<style><%@include file="/WEB-INF/css/style.css"%></style>
	<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<!-- JQUERY -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div class="login-container p-3 border rounded bg-light">
		<form action="checkout" method="post">
		<div style="color: #FF0000;">Payment Details</div>
		<div class="mb-3">
				<label for="pgmFees" class="form-label">Amount To Be Paid ($)</label>
				<input type="text"  class="form-control" name="pgmFees" value = "${pgmFees}" readonly>
			</div>
		
			<div class="mb-3">
				<label for="name" class="form-label">Name on Card</label>
				<input type="text" class="form-control" name="name">
			</div>
			<div class="mb-3">
				<label for="cardNumber" class="form-label">Card Number</label>
				<input type="number" class="form-control" name="cardNumber">
			</div>
			<div class="mb-3">
				<label for="validity" >Valid Through</label>
				<input type="text" class = "form-control" name="validity" placeholder="MM/YY">
				</div>
			<div class="mb-3">
				<label for="cvv" >CVV</label>
				<input type="number" class = "form-control" name="cvv">
			</div>
			<input type="hidden" class="form-control" name="username" value ="${username}">
			<input type="hidden" class="form-control" name="pgmCode" value ="${pgmCode}">
			<input type="hidden" class="form-control" name="pgmDate" value ="${pgmDate}">
			<div class="text-center my-1">
				<button type="submit" class="btn btn-primary">Pay Now</button>
				<button type="Reset" class="btn btn-primary">Clear</button>
			</div>
		</form>
	</div>
</body>
</html>