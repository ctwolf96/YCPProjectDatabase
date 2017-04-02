<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Account Creation</title>
		<link rel="stylesheet" href="StyleLogin.css">
		<meta name = "viewport" content = "width = device-width initial-scale =1">
	</head>
	
	<body>
		<div id="header">
			<div id="logo">
				<img src="Logo.png"/>			
			</div>
		</div>
	<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
	</c:if>
	
	
	

	<form action="${pageContext.servletContext.contextPath}/accountCreationStudent" method="post">
	<div class=container>
	<h1>Account Creation (Student)</h1>
			<table>
				<tr>
					<td class="label">Email:</td>
					<td><input type="text" name="email" size="12" value="${model.email}" /></td>
				</tr>
				<tr>
					<td class="label">Username:</td>
					<td><input type="text" name="username" size="12" value="${model.username}" /></td>
				</tr>
				<tr>
					<td class="label">Password:</td>
					<td><input type="password" name="password" size="12" value="${model.password}" /></td>
				</tr>
				
			</table>
			<p></p>
			<p>Major/Discipline: </p>
			<input type="radio" name="majortype" value="CE"> Computer Engineering<br>
			<input type="radio" name="majortype" value="CS"> Computer Science<br>
			<input type="radio" name="majortype" value="EE"> Electrical Engineering<br>
			<input type="radio" name="majortype" value="ME"> Mechanical Engineering<br>
			
			<p>Current Year: </p>
			<input type="radio" name="classtype" value="FRESHMAN">Freshman<br>
			<input type="radio" name="classtype" value="SOPHOMORE">Sophomore<br>
			<input type="radio" name="classtype" value="JUNIOR">Junior<br>
			<input type="radio" name="classtype" value="SENIOR">Senior<br>
			
			<div id="newLogin">
			<input type="Submit" name="submit" value="Create Account">
			<p></p>
			<input type="Submit" name="faculty" value="Faculty Account Link">
			<input type="Submit" name="guest" value="Guest Account Link">
			</div>
			</div>
		</form>
	</body>
</html>