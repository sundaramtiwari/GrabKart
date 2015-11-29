<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sellers Dashboard</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
	<div id="header" align="center">
		GrabKart
	</div>
	<table border="1" width="100%">
		<tr>
			<th>Product Name</th>
			<th>Price</th>
			<th>Inventory</th>
			<th>Is Product displayed</th>
		</tr>
		<c:forEach items="${requestScope.productList}" var="product">
			<tr>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>${product.quantity}</td>
				<td>
					<c:if test = "${product.visible == '1'}">
						Yes
					</c:if>
					<c:if test = "${product.visible == '0'}">
						No
					</c:if>  
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>