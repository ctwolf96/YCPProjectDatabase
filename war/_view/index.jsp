<!DOCTYPE html>

<html>
	<head>
		<title>Index view</title>
	</head>

	<body>
		<form action= "${pageContext.servletContext.contextPath}/index" method="post">
			<p>If you are a student and need an account, click here!</p>
			<input name="studentCreation" type="submit" value="Student Account Creation" /> 
			<p>If you are part of the faculty and need an account, click here!</p>
			<input name="facultyCreation" type="submit" value="Faculty Account Creation" />
			<p>Otherwise, click here!</p>
			<input name="guestCreation" type="submit" value="Guest Account Creation" />
			<p>Already have an account? Click here!</p>
			<input name="login" type="submit" value="Login Page" />
			<p>Want to find projects? Click here!</p>
			<input name="projectSolicitation" type="submit" value="Project Solicitation" />
		</form>
	</body>
</html>
