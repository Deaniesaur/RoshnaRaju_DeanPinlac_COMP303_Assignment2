<div class="login-container">
	<form action="checkout" method="post">
	<h2>Payment Details</h2>
	<hr>
	<div class="mb-3">
			<label for="pgmFees" class="form-label">Amount To Be Paid ($)</label>
			<input type="text"  class="form-control" name="pgmFees" value = "${pgmFees}" readonly>
		</div>
	
		<div class="mb-3">
			<label for="name" class="form-label">Name on Card</label>
			<input type="text" class="form-control" name="name" required>
		</div>
		<div class="mb-3">
			<label for="cardNumber" class="form-label">Card Number</label>
			<input type="number" class="form-control" onKeyPress="if(this.value.length==16) return false;" name="cardNumber" required>
		</div>
		<div class="d-flex justify-content-between mb-3">
			<div class="pe-2">
				<label for="validity" >Valid Through</label>
				<input type="text" class = "form-control" name="validity" maxlength="5" pattern="(?:0[1-9]|1[0-2])/[0-9]{2}" placeholder="MM/YY" required>
			</div>
			<div class="ps-2">
				<label for="cvv" >CVV</label>
				<input type="number" class="form-control" onKeyPress="if(this.value.length==3) return false;" name="cvv" required>
			</div>
		</div>
		<div class="d-flex justify-content-evenly">
			<button type="Reset" class="px-4 btn btn-secondary">Clear</button>
			<button type="submit" class="btn btn-primary">Pay Now</button>
		</div>
	</form>
	<div class="text-center mt-3">
		<a href="javascript:history.back()">Back</a>
	</div>
</div>