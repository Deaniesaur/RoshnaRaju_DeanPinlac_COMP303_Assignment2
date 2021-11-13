<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<div class="container-fluid">
  		<a class="navbar-brand" href="/">COMP303 - Lab2</a>
	  	<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    	<span class="navbar-toggler-icon"></span>
		</button>
	  	<div class="collapse navbar-collapse" id="navbarSupportedContent">
	    	<ul class="navbar-nav me-auto mb-2 mb-lg-0">
      			<li class="nav-item">
	        		<a class="nav-link active" aria-current="page" href="/programs">Programs</a>
	      		</li>
      			<li class="nav-item">
	        		<a class="nav-link active" aria-current="page" href="/profile">Profile</a>
	      		</li>
	    	</ul>
	    	<c:choose>
				<c:when test="${empty username}">
					<form class="d-flex" action="/login">
			  			<button class="btn btn-outline-light" type="submit">Login</button>
					</form>
				</c:when>
				<c:otherwise>
					<span class="px-3 text-white">Welcome, ${username}</span>
					<form class="d-flex" action="/logout">
			  			<button class="btn btn-outline-light" type="submit">Logout</button>
					</form>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</nav>