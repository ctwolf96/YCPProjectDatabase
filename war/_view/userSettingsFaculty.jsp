<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<title>Faculty User Settings</title>
<link rel="stylesheet" href="FacultySettings.css">
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
	
	<form action="${pageContext.servletContext.contextPath}/userSettingsFaculty"
		method="post">
		<div class="container">
			<h1 style="text-align: center">Faculty User Settings</h1>
			<br>
			<c:if test="${! empty errorMessage}">
				<div class="error">${errorMessage}</div>
			</c:if>
			<table style="margin: 10px">
				<tr>
					<td class="label">Change Username:</td>
					<td><input type="text" placeholder="Change Username" name="username" size="12" value="${model.username}" /></td>
					<td></td>
					<td><input type="Submit" name="changeUsername" value="Change Username" class="button button5" /></td>
				</tr>
				<tr>
					<td class="label">Change Password:</td>
					<td><input type="password" placeholder="Change Password" name="password" size="12" value="${model.password}" /></td>
					<td></td>
					<td><input type="Submit" name="changePassword" value="Change Password" class="button button5" /></td>
				</tr>
				
			</table><br>
			<label><a>Change Major/Discipline:</a></label> <br>
				<input type="radio" name="major" value="CE"> Computer Engineering<br>
				<input type="radio" name="major" value="CS"> Computer Science<br>
				<input type="radio" name="major" value="EE"> Electrical Engineering<br>
				<input type="radio" name="major" value="ME"> Mechanical Engineering<br>
				<input type="radio" name="major" value="CIV"> Civil Engineering<br>
				<input type="radio" name="major" value="UN"> Undeclared<br><br>
				<input type="Submit" name="changeMajor" value="Change Major" class="button button5" /><br><br>
			
			<br>
			<br>
			<input type="Submit" name="done" value="Finish Editing" class="button button5" />
		</div>
		
		</form>
		
	</body>
</html>