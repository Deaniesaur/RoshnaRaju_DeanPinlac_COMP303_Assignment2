<div class="login-container">
	<form action="../checkout">
		<div>
			<h2 class="text-center my-5">Program Details:</h2>
		</div>
		<hr>
		<div>
			<dl class="row justify-content-center">
				<dt class="col-5">Program Name</dt>
				<dd class="col-5">${pgmName}</dd>
			</dl>
			<dl class="row justify-content-center">
				<dt class="col-5">Duration</dt>
				<dd class="col-5">${pgmDuration}</dd>
			</dl>
			<dl class="row justify-content-center">
				<dt class="col-5">Fees</dt>
				<dd class="col-5">${pgmFees}</dd>
			</dl>
		</div>
		<div class="d-flex mt-3 justify-content-evenly">
			<button type="submit" formaction="/programs" class="btn btn-secondary px-4">Back</button>
			<button type="submit" class="btn btn-primary">Checkout</button>
		</div>
	</form>
</div>