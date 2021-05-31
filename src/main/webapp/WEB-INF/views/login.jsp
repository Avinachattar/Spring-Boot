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
.separator {
    display: flex;
    align-items: center;
    text-align: center;
}
.separator::before, .separator::after {
    content: '';
    flex: 1;
    border-bottom: 1px solid #000;
}
.separator::before {
    margin-right: .01em;
}
.separator::after {
    margin-left: .01em;
}
.btn{
width: 200px;}
</Style>
</head>
<body>
	<div class="container">
		<div class="jumbotron bg-info">
			<form action="home" method="post">
				<h2 class="text-center mb-4">Login</h2>
				<div class="form-group">
					<label for="email">Email</label> <input type="email" name="email"
						id="email" class="form-control" required>
					<div class="text-danger">${errorMessage}</div>
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						name="password" class="form-control" required>
					<div class="text-danger">${wrongPassword}</div>
				</div>
				<div class="text-center p-3">
					<input type="submit" value="Login" class="btn btn-outline-light ">
				</div>
				<div class="separator text-center">Not a registered account?</div>
				 <a class="btn btn-outline-light mt-3 ml-3"
					href="/boot/tregister">Register</a>

			</form>
		</div>
	</div>
</body>
</html>