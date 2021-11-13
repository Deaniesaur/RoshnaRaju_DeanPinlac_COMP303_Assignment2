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
	<div class="container p-3 border rounded bg-light">
		<div>
			<h2 class="text-center my-5">Thank you for enrolling!</h2>
		</div>
		<hr>
		<div>
			<dl class="row justify-content-center">
				<dt class="col-2">Name</dt>
				<dd class="col-3">${Name}</dd>
			</dl>
			<dl class="row justify-content-center">
				<dt class="col-2">Program Name</dt>
				<dd class="col-3">${ProgramName}</dd>
			</dl>
			<dl class="row justify-content-center">
				<dt class="col-2">Program Code</dt>
				<dd class="col-3">${Code}</dd>
			</dl>
			<dl class="row justify-content-center">
				<dt class="col-2">Start Date</dt>
				<dd class="col-3">${Date}</dd>
			</dl>
			<dl class="row justify-content-center">
				<dt class="col-2">Amount Paid</dt>
				<dd class="col-3">${Paid}</dd>
			</dl>
		</div>
	</div>
</body>
</html>