<div class="login-container">
	<form action="programs/detail">
	<div style="color: #FF0000;">${errorMessageForPgm}</div>
		<div class="mb-3">
			<div class="mt-3">
				<label for="program" class="form-label">Choose Your Program</label>
				<select name="program" id="model" class="form-control" required>
					<option value="">------ select here ------</option>
					<option value="100">Yoga</option>
				    <option value="101">Swimming</option>
				    <option value="102">Bootcamp</option>
				</select>
			</div>
			<div class="mt-3">
				<label for="pgmDate" class="form-label">Choose Your Start Date</label>
				<input type="date" class="form-control" name="pgmDate" value="${pgmDate}" required>
				<% session.removeAttribute("pgmDate"); %>
			</div>
		</div>
		<div class="d-flex justify-content-evenly mt-5">
			<button type="reset" class="btn btn-secondary">Clear</button>
			<button type="submit" class="btn btn-primary">View Program</button>
		</div>
	</form>
</div>