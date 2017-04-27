<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
	<link rel = "stylesheet" href = "Style.css"/>
	<title> StudentHome </title>
	
</head> 
<body>

	<div id = "header">
		<div id="logo">
			<img src ="Logo.png"/>
		</div>
		<form action="${pageContext.servletContext.contextPath}/studentHome" method="post">
			<ul id = "navbar">
				<li><a><input type="Submit" name="home" value="Home" class = "navButtons"></a></li>
				<li><a><input type="Submit" name="myProjects" value="My Projects" class = "navButtons"></a></li>
				<li><input type="button" name="newProject" value="New Project" class = "dropdownButtons"></li>
					<div class = "dropdownContent">
						<a><input type="Submit" name="proposal" value="New Proposal" class = "navButtons"></a>
						<a><input type="Submit" name="solicitation" value="New Solicitation" class = "navButtons"></a>
					</div>
				<li><a><input type="Submit" name="search" value="Search" class = "navButtons"></a></li>
				<li><a><input type="Submit" name="logout" value="Logout" class = "navButtons"></a></li>	
			</ul>
		</form>
	</div>
	


</body>
</html>