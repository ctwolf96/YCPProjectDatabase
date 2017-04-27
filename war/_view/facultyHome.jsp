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
		<form>
			<ul id = "navbarFaculty">
				<li><a><input type="Submit" name="submit" value="Home" class = "navButtons"></a></li>
				<li><a><input type="Submit" name="submit" value="Approvals" class = "navButtons"></a></li>
				<li><a><input type="Submit" name="submit" value="MyProjects" class = "navButtons"></a></li>
				<li><a><input type="Submit" name="submit" value="New Project" class = "navButtons"></a></li>
				<li><a><input type="Submit" name="submit" value="Search" class = "navButtons"></a></li>
				<li><a><input type="Submit" name="submit" value="Logout" class = "navButtons"></a></li>	
			</ul>
		</form>
	</div>
	


</body>
</html>