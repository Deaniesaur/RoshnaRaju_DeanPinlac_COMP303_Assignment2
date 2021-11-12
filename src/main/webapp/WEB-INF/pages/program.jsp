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
	<div><%= request.getSession().getAttribute("username") %></div>
	<div class="login-container p-3 border rounded bg-light">
		<form action="enroll" method="post">
		<div style="color: #FF0000;">${errorMessageForPgm}</div>
			<div class="mb-3">
				<label for="program" class="form-label">Choose Your Program</label>
				<select name="program" id="model" class="form-control">
				<option value=""></option>
				<option value="100">Yoga</option>
			    <option value="101">Swimming</option>
			    <option value="102">Bootcamp</option>
				</select>
				<label for="pgmDate" class="form-label">Choose Your Start Date</label>
				<input type="date" class="form-control" name="pgmDate">
				
				<input type="hidden" class="form-control" name="username" value ="${username}">
			</div>
			<div class="text-center my-1">
				<button type="submit" class="btn btn-primary">Enroll</button>
				<button type="Reset" class="btn btn-primary">Clear</button>
			</div>
		</form>
	</div>
</body>
</html>