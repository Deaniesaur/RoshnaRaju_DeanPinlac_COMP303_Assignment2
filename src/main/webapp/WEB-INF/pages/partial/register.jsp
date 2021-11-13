<div class="login-container p-3 border rounded bg-light">
	<form action="register" method="post">
       	<div style="color: #FF0000;">${registrationError}</div>
		<div class="mb-3">
			<label for="username" class="form-label">Username</label>
			<input type="text" class="form-control" name="username" value="${username}">
		</div>
		<div class="mb-3">
			<label for="firstname" class="form-label">First Name</label>
			<input type="text" class="form-control" name="firstname" value="${firstname}">
		</div>
		<div class="mb-3">
			<label for="lastname" class="form-label">Last Name</label>
			<input type="text" class="form-control" name="lastname" value="${lastname}">
		</div>
		<div class="mb-3">
			<label for="password" class="form-label">Password</label>
			<input type="password" class="form-control" name="password">
		</div>
		<div class="mb-3">
			<label for="confirmpassword" class="form-label">Confirm Password</label>
			<input type="password" class="form-control" name="confirmpassword">
		</div>
		<div class="text-center my-1">
			<div><button type="submit" class="btn btn-primary">Register</button></div>
			<div class="mt-3"><a href="login">Already have an account?</a></div>
		</div>
	</form>
</div>
<% session.invalidate(); %>