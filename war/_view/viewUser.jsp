<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>

		<title>Project Proposal</title>
		<link rel="stylesheet" href="ProposalPage.css">
		<meta name = "viewport" content = "width = device-width initial-scale =1">
		
	</head>
	
	<body>
	<div id="header">
		<div id="logo">
			<img src="Logo.png">
		</div>
	</div>
	
	
	
	
	
	<div class="superContainer">
	<form action="${pageContext.servletContext.contextPath}/viewUser" method="post">
	<h1 style = "text-align: center">User ${user.username}</h1>
		<label><a>First Name:</a></label><br>
		<p>${user.firstname}</p><br><br>
		
		<label><a>Last Name:</a></label>
		<p>${user.lastname}</p><br><br>
		
		<label><a>Email:</a></label><br>
		<p>${user.email}</p><br><br>
		
		<label><a>User Type:</a></label><br>
		<p>${user.userType}</p><br><br>
		
		<label><a>Major:</a></label><br>
		<p>${user.major}</p><br><br>
		
		<label><a>Class Level:</a></label><br>
		<p>${user.classLevel}</p><br><br>
				
		</form>
		</div>
	</body>
</html>