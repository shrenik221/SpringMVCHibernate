<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>	    
	    <title>User Login</title>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	</head>
	<body>
	    <div class="container">
	        <h3 id="form_header" class="text-warning" align="center">Login Application</h3>
	        <div>&nbsp;</div>
	        <!-- User input form to validate a user -->
	        <form id="user_form" action="deleteProcess" method="GET">
	            <div class="form-group">
	                <label for="user_id">Username:</label>
	                <input type="number" class="form-control" id="user_id" placeholder="Enter username" name="user_id">
	            </div>
	            <button id="confirm_user" type="submit" class="btn btn-primary">Delete</button>
	        </form>
	    </div>
	</body>
</html>