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
	
	<h1 id="webpageTitle">Account Creation (Faculty)</h1>
	
	
	<div id="loginPart">
	<h3 id="webpageSubtitle">Please fill out the following information</h3>
	<form action="${pageContext.servletContext.contextPath}/accountCreationFaculty" method="post">
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
				
				<input type="Submit" name="submit" value="Create Account">
				<p></p>
				<input type="Submit" name="student" value="Student Account Link">
				<input type="Submit" name="guest" value="Guest Account Link">
		</form>
		</div>
	</body>
</html>