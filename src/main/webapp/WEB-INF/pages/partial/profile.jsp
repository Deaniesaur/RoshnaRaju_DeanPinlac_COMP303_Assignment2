<div class="login-container">
	<form action="profile" method="post">
       	<div style="color: #FF0000;">${updateNotification}</div>
       	<% session.removeAttribute("updateNotification"); %>
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