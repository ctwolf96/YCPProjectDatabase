<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
	<link rel = "stylesheet" href = "Style.css"/>
	<title> BusinessHome </title>
	
</head> 
<body>

	<div id = "header">
		<div id="logo">
			<img src ="Logo.png"/>
		</div>
		<form action="${pageContext.servletContext.contextPath}/businessHome" method="post">
			<ul id = "navbar">
				<li><a><input type="Submit" name="home" value="Home" class = "navButtons"></a></li>
				<li><a><input type="Submit" name="myProjects" value="My Proposals" class = "navButtons"></a></li>
				<li><a><input type="Submit" name="proposal" value="New Proposal" class = "navButtons"></a></li>
				<li><a><input type="Submit" name="search" value="Search" class = "navButtons"></a></li>
				<li><a><input type="Submit" name="login" value="Logout" class = "navButtons"></a></li>	
			</ul>
		</form>
	</div>
	


</body>
</html>