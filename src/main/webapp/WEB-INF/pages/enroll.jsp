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
		<div style="color: #FF0000;">Your Program Details</div>
		<br/>
		<ul>
		<li><div>Program Name: ${pgmName}</div></li>
		<li><div>Duration: ${pgmDuration}</div></li>
		<li><div>Fees: ${pgmFees}</div></li>
		</ul>
			<div class="text-center my-1">
				<button type="submit" class="btn btn-primary">Proceed To Checkout</button>
			</div>
		</form>
		<div class="text-center my-1">
		<form action="programs" method="get">
				<button type="submit" class="btn btn-primary">Back</button>
		</form>
		</div>
	</div>
</body>
</html>