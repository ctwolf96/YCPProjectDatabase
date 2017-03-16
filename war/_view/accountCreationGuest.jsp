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
	
	<h1 id="webpageTitle">Account Creation (Guest/Business)</h1>
	
	<div id="loginPart">
	<h3 id="webpageSubtitle">Please fill out the following information</h3>
		<form action="${pageContext.servletContext.contextPath}/accountCreationGuest" method="post">
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
			<input type="Submit" name="submit" value="Create Account">
			<p></p>
			<input type="Submit" name="student" value="Student Account Link">
			<input type="Submit" name="faculty" value="Faculty Account Link">
		</form>
		</div>
	</body>
</html>
