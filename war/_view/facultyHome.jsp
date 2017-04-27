<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
	<link rel = "stylesheet" href = "Style.css"/>
	<title> FacultyHome </title>
	
</head> 
<body>

	<div id = "header">
		<div id="logo">
			<img src ="Logo.png"/>
		</div>
		<form action="${pageContext.servletContext.contextPath}/facultyHome" method="post">
			<ul id = "navbarFaculty">
				<li><a><input type="Submit" name="home" value="Home" class = "navButtons"></a></li>
				<li><a><input type="Submit" name="myApprovals" value="Approvals" class = "navButtons"></a></li>
				<li><a><input type="Submit" name="myProjects" value="My Projects" class = "navButtons"></a></li>
				<li><a><input type="Submit" name="proposal" value="New Project" class = "navButtons"></a></li>
				<li><a><input type="Submit" name="search" value="Search" class = "navButtons"></a></li>
				<li><a><input type="Submit" name="logout" value="Logout" class = "navButtons"></a></li>	
			</ul>
		</form>
	</div>
	


</body>
</html>