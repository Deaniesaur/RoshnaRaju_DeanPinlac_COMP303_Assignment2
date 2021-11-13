<div class="login-container">
	<form action="login" method="post">
       	<div style="color: #FF0000;">${loginError}</div>
       	<%	session.removeAttribute("loginError");	%>
		<div class="mb-3">
			<label for="username" class="form-label">Username</label>
			<input type="text" class="form-control" name="username" value="${username}">
		</div>
		<div class="mb-3">
			<label for="password" class="form-label">Password</label>
			<input type="password" class="form-control" name="password">
		</div>
		<div class="text-center my-1">
			<div><button type="submit" class="btn btn-primary">Login</button></div>
			<div class="mt-3"><a href="register">Don't have account? Register here</a></div>
		</div>
	</form>
</div>