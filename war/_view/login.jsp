<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Login</title>
		<link rel="stylesheet" href="TestCSS.css">
	</head>

	<body>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
	</c:if>
	
		<h1 id="webpageTitle">Account Creation (Student)</h1>
		
		<div id="loginPart">
		<h3 id="webpageSubtitle">Please fill out the following information</h3>
		<form action="${pageContext.servletContext.contextPath}/login" method="post">
			<table>
				<tr>
					<td class="label">Username:</td>
					<td><input type="text" name="username" size="12" value="${username}" /></td>
				</tr>
				<tr>
					<td class="label">Password:</td>
					<td><input type="text" name="password" size="12" value="${password}" /></td>
				</tr>
			</table>
			<input type="Submit" name="submit" value="Login">
		</form>
		</div>
	</body>
</html>