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
		<div id = "header">
			<div id="logo">
				<img src="Logo.png"/>
			</div>
		</div>
	<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
	</c:if>
	
	

		<form action="${pageContext.servletContext.contextPath}/accountCreationBusiness" method="post">
		<div class="container">
		<h1>Account Creation (Business)</h1>
			<table>
				<tr>
					<td class="label">Email:</td>
					<td><input type="text" placeholder="Enter Email" name="email" size="12" value="${model.email}" /></td>
				</tr>
				<tr>
					<td class="label">Username:</td>
					<td><input type="text" placeholder="Enter Username" name="username" size="12" value="${model.username}" /></td>
				</tr>
				<tr>
					<td class="label">Password:</td>
					<td><input type="password" placeholder="Enter Password" name="password" size="12" value="${model.password}" /></td>
				</tr>
			</table>
			<div id="newLogin">
			<input type="Submit" name="submit" value="Create Account">
			<p></p>
			<input type="Submit" name="student" value="Student Account Link">
			<input type="Submit" name="faculty" value="Faculty Account Link">
			</div>
			</div>
		</form>
	</body>
</html>
