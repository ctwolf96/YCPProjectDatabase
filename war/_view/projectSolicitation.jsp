<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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
		<form
			action="${pageContext.servletContext.contextPath}/projectSolicitation"
			method="post">
			<h1 style="text-align: center">Project Solicitation</h1>
			<label><a>Project Title:</a></label><br> <input type="text"
				name="title"><br>
			<br> <label><a>Description:</a></label>
			<textarea name="message" class="description" rows="10" cols="30">
		</textarea>
			<br>
			<br> <label><a>Duration (Semesters):</a></label><br> <select
				name="duration">
				<option value="1" selected>1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
		</select><br><br>
		
		<label><a>Start Date:</a></label><br>
		<input type="date" name="start"><br><br>
		
			<label><a>Majors/Disciplines:</a></label><br>
			<input type="checkbox" name="majora" value="CE">Computer Engineering
			<input type="checkbox" name="majora" value="CS">Computer Science
			<input type="checkbox" name="majors" value="EE">Electrical Engineering
			<input type="checkbox" name="majors" value="ME">Mechanical Engineering
			<input type="checkbox" name="majors" value="CIV">Civil Engineering
			<input type="checkbox" name="majors" value="UN">Undeclared
			<br><br>
			
			<label><a>Student Year(s):</a></label><br>
			<input type="checkbox" name="classes" value="FR">Freshman
			<input type="checkbox" name="classes" value="SO">Sophomore
			<input type="checkbox" name="classes" value="JR">Junior
			<input type="checkbox" name="classes" value="SR">Senior
			<br><br>
			
			<label><a>Solicitation Type:</a></label><br>
			<select> name="solicitationType">
				<option value="ME Capstone">ME Capstone</option>
				<option value="ECE Capstone">ECE Capstone</option>
				<option value="CivE Capstone">CivE Capstone</option>
				<option value="ME/ECE Capstone">ME/ECE Capstone</option>
				<option value="Software Engineering">Software Engineering</option>
				<option value="CS Senior Design 1">CS Senior Design 1</option>
				<option value="CS Senior Design 2">CS Senior Design 2</option>
				<option value="Independent Study">Independent Study</option>
				<option value="CS Internship">CS Internship</option>
				<option value="Engineering Co-op">Engineering Co-op</option>
				<option value="Class Project">Class Project</option>
			<select><br><br>
			
			<label><a>Number of Students:</a></label><br>
			<input type="text" name="numStudents"><br><br>
			
			<label><a>Cost:</a></label><br>
			<input type="text" name="cost"><br><br>
			
			<input type="Submit" name="submit" value="Create Solicitation" class = "button button5">
			
			<input type="Submit" name="proposal" value="Propose Project Form" class = "button button5">
			
		</form>
	</div>
</body>
</html>