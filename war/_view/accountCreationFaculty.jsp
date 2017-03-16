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
					<td><input type="text" name="email" size="12" value="${email}" /></td>
				</tr>
				<tr>
					<td class="label">First name:</td>
					<td><input type="text" name="username" size="12" value="${username}" /></td>
				</tr>
				<tr>
					<td class="label">Password:</td>
					<td><input type="password" name="password" size="12" value="${password}" /></td>
				</tr>
				
			</table>
			<p></p>
			<p>Major/Discipline: </p>
			<input type="radio" name="CE" value="CE"> Computer Engineering<br>
			<input type="radio" name="CS" value="CS"> Computer Science<br>
			<input type="radio" name="EE" value="EE"> Electrical Engineering<br>
			<input type="radio" name="ME" value="ME"> Mechanical Engineering<br>
			
			<input type="Submit" name="submit" value="Create Account">
			<p></p>
			<input type="Submit" name="student" value="Student Account">
			<input type="Submit" name="guest" value="Guest Account">
		</form>
		</div>
	</body>
</html>