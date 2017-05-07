<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<title>Business User Settings</title>
<link rel="stylesheet" href="BusinessSettings.css">
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
	
	<form action="${pageContext.servletContext.contextPath}/userSettingsBusiness"
		method="post">
		<div class="container">
			<h1 style="text-align: center">Business User Settings</h1>
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
			
			
			<br>
			<br>
			<input type="Submit" name="done" value="Finish Editing" class="button button5" />
		</div>
		
		</form>
		
	</body>
</html>