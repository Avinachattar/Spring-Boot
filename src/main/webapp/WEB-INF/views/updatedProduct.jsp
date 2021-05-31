<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
			<form action="updateProduct" method="post">
				<h2 class="text-center mb-4">Update Product</h2>
				<div class="form-group">
					<label for="productId">Product Id</label> <input type="number"
						name="productId" min="1" class="form-control" required>
				</div>
				<div class="form-group">
					<label for="productName">Product Name</label> <input type="text"
						name="productName" class="form-control" required>
				</div>
				<div class="form-group">
					<label for="productCost">Product Cost</label> <input type="number"
						name="productCost" min="1" class="form-control" required>
				</div>
				<div>
					<input type="submit" name="updateProduct" value="Update"
						class="btn btn-outline-light"> <a
						class="btn btn-outline-light" href="homePage">Home</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>