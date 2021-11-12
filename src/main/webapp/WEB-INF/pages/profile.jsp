<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.comp303.lab2.Models.Customer" %>
<%
	Customer customer = (Customer) request.getAttribute("customer");
%>
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
		<form action="profile" method="post">
        	<div style="color: #FF0000;">${errorMessage}</div>
			<div class="mb-3">
				<label for="username" class="form-label">Username</label>
				<input type="text" class="form-control" name="username" value="${customer.getUserName()}" readonly>
			</div>
			<div class="mb-3">
				<label for="firstname" class="form-label">First Name</label>
				<input type="text" class="form-control" name="firstname" value="${customer.getFirstName()}" required/>
			</div>
			<div class="mb-3">
				<label for="lastname" class="form-label">Last Name</label>
				<input type="text" class="form-control" name="lastname" value="${customer.getLastName()}" required/>
			</div>
			<div class="mb-3">
				<label for="lastname" class="form-label">Address</label>
				<input type="text" class="form-control" name="address" value="${customer.getAddress()}" required/>
			</div>
			<div class="mb-3">
				<label for="lastname" class="form-label">City</label>
				<input type="text" class="form-control" name="city" value="${customer.getCity()}" required/>
			</div>
			<div class="mb-3">
				<label for="lastname" class="form-label">Postal Code</label>
				<input type="text" class="form-control" name="postalcode" value="${customer.getPostalCode()}" required/>
			</div>
			<div class="text-center my-1">
				<div><button type="submit" class="btn btn-primary">Update Profile</button></div>
				<div class="mt-3"><a href="programs">Cancel</a></div>
			</div>
		</form>
	</div>
</body>
</html>