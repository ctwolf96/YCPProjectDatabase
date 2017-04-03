<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Login</title>
		<link rel="stylesheet" href="Login.css">
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
	
		
		<div class="container">
		<h1 style = "text-align: center">Login Page</h1>
		
		<form action="${pageContext.servletContext.contextPath}/login" method="post">
			<table style = "margin: 10px">
				<tr>
					<td class="label">Username:</td>
					<td><input type="text" placeholder="Enter Username" name="username" size="12" value="${model.username}" /></td>
				</tr>
				<tr>
					<td class="label">Password:</td>
					<td><input type="password" placeholder="Enter Password" name="password" size="12" value="${model.password}" /></td>
				</tr>
			</table>
			<input type="Submit" name="submit" value="Login">
		</form>
		</div>
	</body>
</html>