<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<title>Project Proposal Settings</title>
<link rel="stylesheet" href="proposalSettings.css">
<meta name="viewport" content="width = device-width initial-scale =1">
</head>

<body>
	<div id="header">
		<div id="logo">
			<img src="Logo.png" />
		</div>
	</div>
	<c:if test="${! empty errorMessage}">
		<div class="error">${errorMessage}</div>
	</c:if>
	
	<form action="${pageContext.servletContext.contextPath}/projectSettingsProposal"
		method="post">
		<div class="container">
			<h1 style="text-align: center">Project Proposal Settings</h1>
			<br>
			<c:if test="${! empty errorMessage}">
				<div class="error">${errorMessage}</div>
			</c:if>
			<table style="margin: 10px">
				<tr>
					<td class="label">Change Title:</td>
					<td><input type="text" placeholder="Change Title" name="title" size="12" value="${model.title}" /></td>
					<td><input type="Submit" name="changeTitle" value="Change Title" class="button button5" /></td>
				</tr>
				<tr>
					<td class="label">Change Description:</td>
					<td><input type="text" placeholder="Change Description" name="description
					" size="12" value="${model.description}" /></td>
					<td><input type="Submit" name="changeDescription" value="Change Description" class="button button5" /></td>
				</tr>
				<tr>
					<td class="label">Change Start Date:</td>
					<td><input type="date"  name="start"/></td>
					<td><input type="Submit" name="changeStartDate" value="Change Start Date" class="button button5" /></td>
				</tr>
				<tr>
					<td class="label">Change Number of Students:</td>
					<td><input type="text" name="numStudents"/></td>
					<td><input type="Submit" name="changeNumStudents" value="Change Number of Students" class="button button5" /></td>
				</tr>
				<tr>
					<td class="label">Change Cost:</td>
					<td><input type="text" name="cost"/></td>
					<td><input type="Submit" name="changeCost" value="Change Cost" class="button button5" /></td>
				</tr>	
			</table>
			<label><a>Change Duration (Semesters):</a></label><br>
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
			<input type="Submit" name="changeDuration" value="Change Duration" class="button button5" /><br><br>
			
			<labeL><a>Change Majors Involved:</a></labeL><br>
			<input type="checkbox" name="majors" value="CE">Computer Engineering
			<input type="checkbox" name="majors" value="CS">Computer Science
			<input type="checkbox" name="majors" value="EE">Electrical Engineering
			<input type="checkbox" name="majors" value="CivE">Civil Engineering
			<input type="checkbox" name="majors" value="ME">Mechanical Engineering<br><br>
			<input type="Submit" name="changeMajor" value="Change Major" class="button button5" /><br><br>
			
			<label><a>Change Student Year(s):</a></label><br>
			<input type="checkbox" name="classes" value="FR">Freshman
			<input type="checkbox" name="classes" value="SO">Sophomore
			<input type="checkbox" name="classes" value="JR">Junior
			<input type="checkbox" name="classes" value="SR">Senior<br><br>
			<input type="Submit" name="changeClass" value="Change Class" class="button button5" /><br><br>
			<input type="Submit" name="done" value="finishEditing" class="button button5" />
		</div>
		
		
		
		
		</form>
		
	</body>
	</html>	