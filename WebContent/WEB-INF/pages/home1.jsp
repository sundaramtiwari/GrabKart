<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Welcome To GrabKart</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="css/style.css" type="text/css" />

</head>
<body>
	<div id="header" align="center">
		GrabKart
	</div>
	<div id="errDiv" class="errClass">
		${requestScope.errorMessage}
	</div>
	<div id="msgDiv" class="msgClass">
		${requestScope.message}
	</div>
<div class="container-fluid">
	<div class="row">
		<form:form method="POST" action="login" commandName="user">
		<div class="col-sm-3"></div>
	  	<div class="col-sm-3 text-info text-justify" align="right">
	  		<form:label path="userName">UserName:</form:label> <br />
	  		<form:label path="password">Password: </form:label> <br />
	  		<br /><br /><br />
	  		New to GrabKart? Register <a href="register">here</a>
	  	</div>
	  	<div class="col-sm-3" align="left">
	  		<form:input path="userName" /><form:errors path="userName" cssClass="errClass" /> <br />
	  		<form:input path="password" /><form:errors path="password" cssClass="errClass" /> <br /><br />
	  		<input type="submit" value="Login" /> <br />
	  		<br />
	  	</div>
	  	<div class="col-sm-3"></div>
	  	</form:form>
	</div>		
</div>
</body>
</html>