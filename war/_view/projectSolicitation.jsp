<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Account Creation</title>
		<link rel="stylesheet" href="TestCSS.css">
	</head>
	
	<body>
	<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
	</c:if>
	
	<h1 id="webpageTitle">Project Solicitation</h1>
	
	
	<div id="loginPart">
	<h3 id="webpageSubtitle">Please fill out the following information</h3>
	<form action="${pageContext.servletContext.contextPath}/projectSolicitation" method="post">
	
		<p>Hardware?</p>
		<select name="hardware">
			<option value="true">Yes</option>
			<option value="false">No</option>
		</select>
		<p>Software?</p>
		<select name="hardware">
			<option value="true">Yes</option>
			<option value="false">No</option>
		</select>
		
			<table>
				<tr>
					<td class="label">Duration of Project (# of semesters):</td>
					<td><input type="text" name="duration" size="12" value="${startTime}" /></td>
				</tr>
				<tr>
					<td class="label">Start Time:</td>
					<td><input type="text" name="startTime" size="12" value="${startTime}" /></td>
				</tr>
			</table>
			<br>
			
			<p>Majors/Disciplines: </p>
			<input type="checkbox" name="computerEngineer" value="CE">Computer Engineering<br>
			<input type="checkbox" name="computerScience" value="CS">Computer Science<br>
			<input type="checkbox" name="electricalEngineer" value="EE">Electrical Engineering<br>
			<input type="checkbox" name="mechanicalEngineer" value="ME">Mechanical Engineering<br>
			<br>
			<p>Student Class</p>
			<input type="checkbox" name="freshman" value="FR">Freshman<br>
			<input type="checkbox" name="sophomore" value="SO">Sophomore<br>
			<input type="checkbox" name="junior" value="JR">Junior<br>
			<input type="checkbox" name="senior" value="SR">Senior<br>
			<br>
			<input type="Submit" name="submit" value="Find Projects">
			<br>
			<br>
			<input type="Submit" name="project" value="Project Creation">
			
		</form>
		</div>
	</body>
</html>