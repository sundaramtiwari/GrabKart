<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register on Grabkart</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
	<div id="header" align="center">
		GrabKart
	</div>
	<div id="errDiv" class="errClass">
		${requestScope.errorMessage}
	</div>
	<form:form method="POST" action="register" commandName="user">
		<div align="center">
			<table>
			<tr>
				<td><form:label path="userName">UserName:</form:label></td>
				<td><form:input path="userName" /></td>
				<td><form:errors path="userName" cssClass="errClass" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:input path="password" /></td>
				<td><form:errors path="password" cssClass="errClass" /></td>
			</tr>
			<tr>
				<td>User Type:</td>
				<td>
					<input type="radio" name="type" value="buyer" /> Buyer
					<input type="radio" name="type" value="seller" /> Seller
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Create Account" /></td>
				<td><input type="reset" value="Reset" /></td>
			</tr>
		</table>
		</div>
	</form:form>
</body>
</html>