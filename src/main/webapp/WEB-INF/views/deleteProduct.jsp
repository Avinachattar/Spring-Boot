<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<div class="jumbotron">
		<h2 class="text-center">Product Deleted Successfully</h2>
		<h3 class="text-center p-3">Deleted product detail: ${product}</h3>
		<div class="text-center p-3">
			<a class="btn btn-info ml-3" href="/boot/homePage">Home</a> <a
				class="btn btn-info ml-3" href="/boot/productDetail">Add Product</a>
		</div>
	</div>
</body>
</html>