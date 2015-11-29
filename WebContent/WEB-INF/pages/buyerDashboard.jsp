<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buyers Dashboard</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
	<div id="header" align="center">
		GrabKart
	</div>
	<table border="0" width="80%">
		<tr>
			<th>Product Name</th>
		</tr>
		<c:forEach items="${requestScope.productList}" var="product">
			<tr>
				<td>
					<img src=${product.image} style="width:200px;height:300px;"> <br />
					${product.name}
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>