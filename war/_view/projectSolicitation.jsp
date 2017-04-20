<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Project Solicitation</title>
		<link rel="stylesheet" href="Solicitation.css">
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
	<form action="${pageContext.servletContext.contextPath}/projectSolicitation" method="post">
	<h1 style = "text-align: center">Project Solicitation</h1>
		<label><a>Project Title</a></label><br>
		<input type="text" name="title"><br>
		<label><a>Description</a></label>
		<textarea name="message" class="description" rows="10" cols="30">
		</textarea><br><br>
		<label><a>Duration (Semesters)</a></label><br>
		<select name="duration">
				<option value="1"selected>1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
		</select><br>
		<label><a>Start Date (mm/dd/yyyy)</a></label><br>
		<input type="text" name="startDate"><br><br>
		
			<p>Majors/Disciplines: </p>
			<input type="checkbox" name="CE" value="CE">Computer Engineering<br>
			<input type="checkbox" name="CS" value="CS">Computer Science<br>
			<input type="checkbox" name="EE" value="EE">Electrical Engineering<br>
			<input type="checkbox" name="ME" value="ME">Mechanical Engineering<br>
			<br>
			
			<p>Student Class</p>
			<input type="checkbox" name="freshman" value="FR">Freshman<br>
			<input type="checkbox" name="sophomore" value="SO">Sophomore<br>
			<input type="checkbox" name="junior" value="JR">Junior<br>
			<input type="checkbox" name="senior" value="SR">Senior<br>
			<br>
			
			<input type="Submit" name="submit" value="Create Solicitation" class = "button button5">
			
			<input type="Submit" name="project" value="Project Creation Link" class = "button button5">
			
		</form>
		</div>
	</body>
</html>