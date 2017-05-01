<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
	<link rel = "stylesheet" href = "StyleLogin.css"/>
	<title> Login </title>
	<meta name = "viewport" content-type = "width = device-width initial-scale =1">
</head> 
<body>
	<div id = "header">
		<div id="logo">
			<img src ="Logo.png"/>
		</div>
	</div>
	<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
	</c:if>
	<div class="container">
	<form action="${pageContext.servletContext.contextPath}/login" method="post">
			<table style = "margin: 10px">
				<tr>
					<td class="label">Username: ${errorMessage}</td>
				</tr>
				
				<tr>
					<td><input type="text" placeholder="Enter Username" name="username" size="12" value="${model.username}" /></td>
				</tr>
				<tr>
					<td class="label">Password:</td>
				</tr>
				<tr>
					
					<td><input type="password" placeholder="Enter Password" name="password" size="12" value="${model.password}" /></td>
				</tr>
			</table>
			<div style = "margin-left: 23px">
				<input type="Submit" class = "button5 button" name="submit" value="Login">
				<input name = "SignUp" type="Submit" class = "button5 button" name="submit" value="Sign Up">
			</div>
		</form>
		
	</div>
	

</body>
</html>