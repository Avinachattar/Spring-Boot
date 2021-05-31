<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<Style>
.jumbotron {
	display: flex;
	justify-content: center;
	align-items: center;
	width: 60%;
	left: 20%;
	position: fixed;
}
</Style>
</head>
<body>
	<div class="container">
		<div class="jumbotron bg-info">
			<form action="otp" method="post">
				<h2 class="text-center mb-4">Register Here</h2>
				<div class="form-group">
					<label for="fullName">Full Name</label> <input type="text"
						name="fullName" class="form-control" id="fullName" required>
						<div class="text-danger">${fullname}</div>

				</div>
				<div class="form-group">
					<label for="phoneNumber">Phone Number</label> <input type="number"
						name="phoneNumber" class="form-control" id="phoneNumber" required>
				</div>
				<div class="form-group">
					<label for="email">Email</label> <input type="email" name="email"
						id="email" min="0" class="form-control" required>
					<div class="text-danger">${errorMessage}</div>
					<div class="text-danger">${message}</div>

				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						name="password"  class="form-control" required>
				</div>
				<div class="text-center p-3">
				
				<input type="submit" name= "otp" class="btn btn-outline-light ml-3" value="Regsiter">
					<a
						class="btn btn-outline-light ml-3" href="/boot/index">Already
						Registered? Login</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>