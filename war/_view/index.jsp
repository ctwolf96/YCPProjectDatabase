<!DOCTYPE html>

<html>
	<head>
		<title>Index view</title>
	</head>

	<body>
		<form action= "${pageContext.servletContext.contextPath}/index" method="post">
			<input name="studentCreation" type="submit" value="Student Account Creation" /> 
			<input name="facultyCreation" type="submit" value="Faculty Account Creation" />
			<input name="guestCreation" type="submit" value="Guest Account Creation" />
			<input name="login" type="submit" value="Login Page" />
		</form>
	</body>
</html>
