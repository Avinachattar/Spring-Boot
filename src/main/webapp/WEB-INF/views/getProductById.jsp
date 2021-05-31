<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"
	import="com.zensar.spring.model.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<div class="jumbotron">
		<h2 class="text-center">Product Detail</h2>
		<h4 class="text-center p-3">${product}</h4>
		<div class="text-center p-3">
			<a class="btn btn-info ml-3" href="/boot/homePage">Home</a> <a
				class="btn btn-info ml-3" href="/boot/productDetail">Add Product</a>
		</div>
	</div>
</body>
</html>