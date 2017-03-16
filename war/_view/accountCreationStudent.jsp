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
	
	<h1 id="webpageTitle">Account Creation (Student)</h1>
	
	<div id="loginPart">
	<h3 id="webpageSubtitle">Please fill out the following information</h3>
	<form action="${pageContext.servletContext.contextPath}/accountCreationStudent" method="post">
			<table>
				<tr>
					<td class="label">Email:</td>
					<td><input type="text" name="email" size="12" value="${email}" /></td>
				</tr>
				<tr>
					<td class="label">Username:</td>
					<td><input type="text" name="username" size="12" value="${username}" /></td>
				</tr>
				<tr>
					<td class="label">Password:</td>
					<td><input type="password" name="password" size="12" value="${password}" /></td>
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
			
			<input type="Submit" name="submit" value="Create Account">
			<p></p>
			<input type="Submit" name="faculty" value="Faculty Account Link">
			<input type="Submit" name="guest" value="Guest Account Link">
		</form>
		</div>
	</body>
</html>