<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<header>
		<title>User Search</title>
		<link rel="stylesheet" href="Search.css">
		<meta name="viewport" content="width = device-width initial-scale=1">
	</head>
	
	<body>
	<div id="header">
		<div id="logo">
			<img src="Logo.png">
		</div>
	</div>
	<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
	</c:if>
	
	<div class="superContainer">
	<form action="${pageContext.servletContext.contextPath}/userSearch" method="post">
	<h1 style = "text-align: center">User Search</h1>
		<p>Select a field to search by and click "Search"</p><br>
		
		<label><a>Username:</a></label><br>
		<input type="text" name="username"><br><br>
		
		<label><a>Email:</a></label>
		<input type="text" name="email"><br><br>
		
		<label><a>User Type:</a></label><br>
		<select name="usertype">
				<option value="Student"selected>Student</option>
				<option value="Faculty">Faculty</option>
				<option value="Business">Business</option>
		</select><br><br>
		
		<label><a>Firstname:</a></label><br>
		<input type="text" name="firstname"><br><br>
		
		<label><a>Lastname:</a></label><br>
		<input type="text" name="lastname"><br><br>
		
			<label><a>Major/Discipline:</a></label><br>
			<select name="major">
			<option value="CE">Computer Engineering</option>
			<option value="CS">Computer Science</option>
			<option value="EE">Electrical Engineering</option>
			<option value="ME">Mechanical Engineering</option>
			<option value="CivE">Civil Engineering</option>
			</select><br><br>
			
			<label><a>Student Year:</a></label><br>
			<select name="class">
			<option value="Freshman">Freshman</option>
			<option value="Sophomore">Sophomore</option>
			<option value="Junior">Junior</option>
			<option value="Senior">Senior</option>
			</select><br><br>
			
			<label><a>Business Name:</a></label><br>
			<input type="text" name="name"><br><br>
			
			<label><a>Business Address:</a></label><br>
			<input type="text" name="address"><br><br>
			
			<label><a>Business Number:</a></label><br>
			<input type="text" name="number"><br><br>
			
			<input type="Submit" name="submit" value="Search" class = "button button5">
			
		</form>
		</div>
	</body>
</html>