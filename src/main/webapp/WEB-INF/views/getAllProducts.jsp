<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
</head>
<body>
	<div class="container">
		<h2 class="text-center display-4 mb-4 mt-3">All Product Details</h2>
		<table class="table table-hover p-3 mt-3" border="1">

			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Product Cost</th>
				<c:forEach items="${list}" var="product">
					<tr>
						<td>${product.productId}</td>
						<td><c:out value="${product.productName}" /></td>
						<td><c:out value="${product.productCost}" /></td>
					</tr>
				</c:forEach>
		</table>
		<div class="text-center p-3">
			<a class="btn btn-info ml-3" href="/boot/homePage">Home</a> <a
				class="btn btn-info ml-3" href="/boot/productDetail">Add Product</a>
		</div>
	</div>
	</div>
</body>
</html>