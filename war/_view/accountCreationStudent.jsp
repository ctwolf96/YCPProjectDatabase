<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<title>Account Creation</title>
<link rel="stylesheet" href="StudentAccountCreation.css">
<meta name="viewport" content="width = device-width initial-scale =1">
</head>

<body>
	<div id="header">
		<div id="logo">
			<img src="Logo.png" />
		</div>
	</div>
	<form
		action="${pageContext.servletContext.contextPath}/accountCreationStudent"
		method="post">
		<div class=container>
			<h1 style="text-align: center">Student Account Creation</h1>
			<br>
			<c:if test="${! empty errorMessage}">
				<div class="error">${errorMessage}</div>
			</c:if>
			<table>
				<tr>
					<td class="label">First Name:</td>
					<td><input type="text" placeholder="Enter First Name"
						name="firstName" size="12" value="${model.name}" /></td>
				</tr>
				<tr>
					<td class="label">Last Name:</td>
					<td><input type="text" placeholder="Enter Last Name"
						name="lastName" size="12" value="${model.name}" /></td>
				</tr>
				<tr>
					<td class="label">Email:</td>
					<td><input type="text" placeholder="Enter Email" name="email"
						size="12" value="${model.email}" /></td>
				</tr>
				<tr>
					<td class="label">Username:</td>
					<td><input type="text" placeholder="Enter Username"
						name="username" size="12" value="${model.username}" /></td>
				</tr>
				<tr>
					<td class="label">Password:</td>
					<td><input type="password" placeholder="Enter Password"
						name="password" size="12" value="${model.password}" /></td>
				</tr>
				<tr>
					<td class="label">Re-enter Password:</td>
					<td><input type="password" placeholder="Re-enter Password"
						name="password1" size="12" value="${model.password1}" /></td>
				</tr>

			</table>
			<p></p>
			<label><a>Major/Discipline</a></label><br> <input type="radio"
				name="majortype" value="CE"> Computer Engineering<br> <input
				type="radio" name="majortype" value="CS"> Computer Science<br>
			<input type="radio" name="majortype" value="EE"> Electrical
			Engineering<br> <input type="radio" name="majortype" value="ME">
			Mechanical Engineering<br> <input type="radio" name="majortype"
				value="CivE"> Civil Engineering<br>
			<br> <label><a>Current Year</a></label><br> <input
				type="radio" name="classtype" value="FRESHMAN">Freshman<br>
			<input type="radio" name="classtype" value="SOPHOMORE">Sophomore<br>
			<input type="radio" name="classtype" value="JUNIOR">Junior<br>
			<input type="radio" name="classtype" value="SENIOR">Senior<br>
			<br>

			<div id="newLogin">
				<input type="Submit" name="submit" value="Create Account"
					class="button button5"> <input type="Submit" name="faculty"
					value="Faculty Account" class="button button5"> <input
					type="Submit" name="business" value="Business Account"
					class="button button5">
			</div>
		</div>
	</form>
</body>
</html>