<!DOCTYPE html>

<html>
	<head>
		<link rel="stylesheet" href="Style.css">
		<title>Index view</title>
		<meta name = "viewport" content = "width = device-width initial-scale =1">
	</head>

	<body>
	<div id = "header">
		<div id = "logo">
			<img src="Logo.png"/>
		</div>
		<div id="navbar">
		<form action= "${pageContext.servletContext.contextPath}/index" method="post">
			<input name="studentCreation" type="submit" value="Student Account Creation" /> 
			<input name="facultyCreation" type="submit" value="Faculty Account Creation" />
			<input name="guestCreation" type="submit" value="Guest Account Creation" />
			<input name="login" type="submit" value="Login Page" />
			<input name="projectSolicitation" type="submit" value="Project Solicitation" />
			<input name="projectProposal" type="submit" value="Project Proposal" />
		</form>
		</div>
		</div>
	</body>
</html>
