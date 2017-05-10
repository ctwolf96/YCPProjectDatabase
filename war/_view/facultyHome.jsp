<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<link rel="stylesheet" href="Style.css" />
<title>FacultyHome</title>

</head>
<body>

	<div id="header">
		<div id="logo">
			<img src="Logo.png" />
		</div>
		<div id = "text">
			<h1> Hello, ${user.username} </h1>
		</div>
		<form action="${pageContext.servletContext.contextPath}/facultyHome" method="post">
		<div class="dropdown">
			<button class="dropbtn">Menu</button>
			<div class="dropdown-content">
				  	<a><input type="Submit" name="home" value="Home" class = "buttonDrop" ></a>
					<a><input type="Submit" name="myApprovals" value="Approvals" class = "buttonDrop" ></a>				  
					<a><input type="Submit" name="myProjects" value="My Projects" class = "buttonDrop" ></a>				 
					<a><input type="Submit" name="proposal" value="New Project" class = "buttonDrop" ></a>	
					<a><input type="Submit" name="solicitation" value= "New Solicitation" class = "buttonDrop" ></a>
					<a><input type="Submit" name="userSearch" value="User Search" class = "buttonDrop"></a>
					<a><input type="Submit" name="proposalSearch" value="Proposal Search" class = "buttonDrop" ></a>
					<a><input type="Submit" name="solicitationSearch" value="Solicitation Search" class = "buttonDrop" ></a>
					<a><input type="Submit" name="logout" value="Logout" class = "buttonDrop" ></a>	
						
			</div>
			</div>
		</form>
	</div>



</body>
</html>