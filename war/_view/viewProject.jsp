<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>

		<title>Project Proposal</title>
		<link rel="stylesheet" href="ProposalPage.css">
		<meta name = "viewport" content = "width = device-width initial-scale =1">
		
	</head>
	
	<body>
	<div id="header">
		<div id="logo">
			<img src="Logo.png">
		</div>
	</div>
	
	<form action="${pageContext.servletContext.contextPath}/viewProject" method="post">
	
	<div class="dropdown">
			<button class="dropbtn">Menu</button>
			<div class="dropdown-content">
				  	<a><input type="Submit" name="home" value="Home" class = "buttonDrop" ></a>				  
					<a><input type="Submit" name="myProjects" value="My Projects" class = "buttonDrop" ></a>				 
					<a><input type="Submit" name="proposal" value="New Proposal" class = "buttonDrop" ></a>	
					<a><input type="Submit" name="solicitation" value= "New Solicitation" class = "buttonDrop" ></a>
					<a><input type="Submit" name="userSearch" value="User Search" class = "buttonDrop"></a>
					<a><input type="Submit" name="proposalSearch" value="Proposal Search" class = "buttonDrop"></a>
					<a><input type="Submit" name="solicitationSearch" value="Solicitation Search" class = "buttonDrop"></a>
					<a><input type="Submit" name="settings" value="Edit Settings" class = "buttonDrop"></a>
					<a><input type="Submit" name="logout" value="Logout" class = "buttonDrop" ></a>		
			</div>
	</div>
	
	<div class="superContainer">
	<h1 style = "text-align: center">Proposal</h1>
		<label><a>Project Title:</a></label><br>
		<p>${project.title}</p><br><br>
		
		<label><a>Description:</a></label>
		<p>${project.description}</p><br>
		
		<label><a>Duration (Semesters):</a></label><br>
		<p>${project.duration}</p><br>
		
		<label><a>Start Date:</a></label><br>
		<p>${project.start}</p><br>
		
		<label><a>Deadline:</a></label><br>
		<p>${project.deadline}</p><br>
		
		<label><a>Funding:</a></label><br>
		<p>${project.isFunded}</p><br>
		
		<labeL><a>Number of Students:</a></labeL><br>
		<p>${project.numStudents}</p><br>
			
		<labeL><a>Majors Involved</a></labeL><br>
		<c:forEach items="${project.majors}" var="major">
			<p>${major.toString}</p>
		</c:forEach>
			
		<label><a>Student Year(s)</a></label><br>
		<c:forEach items="${project.classes}" var="class">
			<p>${class.toString}</p>
		</c:forEach>
			
		<label><a>Cost:</a></label><br>
		<p>${project.cost}</p><br><br>
		
		<div id="newLogin">
			<input type="Submit" name="editProject" value="Edit Project" class = "button button5">
		</div>		
		</div>
	</form>
	</body>
</html>