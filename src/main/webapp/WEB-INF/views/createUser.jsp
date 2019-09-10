<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	</head>
	<body>
	        <form id="createform" action="signup" method="GET">
	            <div class="form-group">
	                <label for="username">Username:</label>
	                <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
	            </div>
	            <div class="form-group">
	                <label for="password">Password:</label>
	                <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
	            </div>
	            <button id="create_user" type="submit" class="btn btn-primary">Sign-up</button>
	        </form>	    
	</body>
</html>