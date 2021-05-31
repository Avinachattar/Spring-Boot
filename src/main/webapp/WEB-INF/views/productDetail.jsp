<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
			<form action="insertProduct" method="post">
				<h2 class="text-center mb-4">Insert Product Here</h2>
				<div class="form-group">
					<label for="productName">Product Name</label> <input type="text"
						name="productName" class="form-control" required>
				</div>
				<div class="form-group">
					<label for="productCost">Product Cost</label> <input type="number"
						name="productCost" min="0" class="form-control" required>
				</div>
				<div class="text-center p-3">
					<input type="submit" name="insertProduct" value="Insert"
						class="btn btn-outline-light"> <a
						class="btn btn-outline-light ml-3" href="/boot/homePage">Home</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>