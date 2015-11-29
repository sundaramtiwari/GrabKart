<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Welcome To GrabKart</title>
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="css/style.css" type="text/css" />
	<script src="js/effects.js"></script>
</head>

<body>
	<!-- BEGIN # BOOTSNIP INFO -->
<div class="container">
	<div class="row">
		<h1 class="text-center">Welcome to GrabKart.</h1>
        <p class="text-center"><a id="login_link" href="#" class="btn btn-primary btn-lg" role="button" data-toggle="modal" data-target="#login-modal">Login</a></p>
        <input type="hidden" id="invalidUser" name="invalidUser" value='${invalidUser}' />
	</div>
</div>
<!-- END # BOOTSNIP INFO -->

<!-- BEGIN # MODAL LOGIN -->
<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    	<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" align="center">
					<!-- <img class="img-circle" id="img_logo" src="http://bootsnipp.com/img/logo.jpg"> -->
					GrabKart
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					</button>
				</div>
                
                <!-- Begin # DIV Form -->
                <div id="div-forms">
                
                    <!-- Begin # Login Form -->
                    <form:form method="POST" action="login" commandName="user" id="login-form">
                    <%-- <form id="login-form"> --%>
		                <div class="modal-body">
				    		<div id="div-login-msg">
                                <div id="icon-login-msg" class="glyphicon glyphicon-chevron-right"></div>
                                <span id="text-login-msg">Type your username and password.</span>
                                <%-- <c:choose>
                                	<c:when test="${requestScope.invalidUser}">
                                		<span id="text-login-msg" class="" >Invalid username/password</span>
                                	</c:when>
                                	<c:otherwise>
                                		<span id="text-login-msg">Type your username and password.</span>
                                	</c:otherwise>
                                </c:choose> --%>
                            </div>
                            <form:input path="userName" id="login_username" class="form-control" type="text" placeholder="Username (type ERROR for error effect)" required="true" />
				    		<!-- <input id="login_username" class="form-control" type="text" placeholder="Username (type ERROR for error effect)" required> -->
				    		<form:input path="password" id="login_password" class="form-control" type="password" placeholder="Password" required="true" />
				    		<!-- <input id="login_password" class="form-control" type="password" placeholder="Password" required> -->
                            <!-- <div class="checkbox">
                                <label>
                                    <input type="checkbox"> Remember me
                                </label>
                            </div> -->
        		    	</div>
				        <div class="modal-footer">
                            <div>
                                <button type="submit" class="btn btn-primary btn-lg btn-block">Login</button>
                            </div>
				    	    <div>
                                <button id="login_lost_btn" type="button" class="btn btn-link">Lost Password?</button>
                                <button id="login_register_btn" type="button" class="btn btn-link">Register</button>
                            </div>
				        </div>
                    <%-- </form> --%>
                    </form:form>
                    <!-- End # Login Form -->
                    
                    <!-- Begin | Lost Password Form -->
                    <form id="lost-form" style="display:none;">
    	    		    <div class="modal-body">
		    				<div id="div-lost-msg">
                                <div id="icon-lost-msg" class="glyphicon glyphicon-chevron-right"></div>
                                <span id="text-lost-msg">Type your e-mail.</span>
                            </div>
		    				<input id="lost_email" class="form-control" type="text" placeholder="E-Mail (type ERROR for error effect)" required>
            			</div>
		    		    <div class="modal-footer">
                            <div>
                                <button type="submit" class="btn btn-primary btn-lg btn-block">Send</button>
                            </div>
                            <div>
                                <button id="lost_login_btn" type="button" class="btn btn-link">Log In</button>
                                <button id="lost_register_btn" type="button" class="btn btn-link">Register</button>
                            </div>
		    		    </div>
                    </form>
                    <!-- End | Lost Password Form -->
                    
                    <!-- Begin | Register Form -->
                    <%-- <form id="register-form" style="display:none;"> --%>
                    <form:form method="POST" action="register" commandName="user" id="register-form" style="display:none;">
            		    <div class="modal-body">
		    				<div id="div-register-msg">
                                <div id="icon-register-msg" class="glyphicon glyphicon-chevron-right"></div>
                                <span id="text-register-msg">Register an account.</span>
                            </div>
		    				<form:input path="userName" id="register_username" class="form-control" type="text" placeholder="Username (type ERROR for error effect)" required="true" />
                            <!-- <input id="register_email" class="form-control" type="text" placeholder="E-Mail" required> -->
                           <form:input path="password" id="register_password" class="form-control" type="password" placeholder="Password" required="true" />
                           <br />User Type: 
                           <input type="radio" name="type" value="buyer" /> Buyer
						   <input type="radio" name="type" value="seller" /> Seller
            			</div>
		    		    <div class="modal-footer">
                            <div>
                                <button type="submit" class="btn btn-primary btn-lg btn-block">Register</button>
                            </div>
                            <div>
                                <button id="register_login_btn" type="button" class="btn btn-link">Log In</button>
                                <button id="register_lost_btn" type="button" class="btn btn-link">Lost Password?</button>
                            </div>
		    		    </div>
					</form:form>
                    <%-- </form> --%>
                    <!-- End | Register Form -->
                    
                </div>
                <!-- End # DIV Form -->
                
			</div>
		</div>
	</div>
    <!-- END # MODAL LOGIN -->
</body>
</html>