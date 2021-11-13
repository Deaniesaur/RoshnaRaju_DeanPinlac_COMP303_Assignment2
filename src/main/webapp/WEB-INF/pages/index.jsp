<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
	String p = request.getAttribute("partial").toString();
	String pagePath = "partial/" + p + ".jsp";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>COMP303 Assignment 2</title>
	<!-- Custom CSS -->
	<style><%@include file="/WEB-INF/css/style.css"%></style>
	<!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<!-- JQUERY -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body class="d-flex flex-column vh-100">
	<header>
		<jsp:include page="header.jsp" ></jsp:include>
	</header>
	<main class="flex-grow-1">
		<div class="container-lg p-3 my-3 border rounded bg-light">
			<jsp:include page="<%= pagePath %>" ></jsp:include>
		</div>
	</main>
	<footer class="footer mt-auto py-3 bg-light">
		<jsp:include page="footer.jsp" ></jsp:include>
	</footer>
</body>
</html>