<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>

<title>My Projects</title>
<link rel="stylesheet" href="Style.css">
</head>

<body>
	<div id="header">
		<div id="logo">
			<img src="Logo.png">
		</div>
	<c:if test="${! empty errorMessage}">
		<div class="error">${errorMessage}</div>
	</c:if>
	<form action="${pageContext.servletContext.contextPath}/myProjects" method="post">
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
	</div>
		

	<div class="superContainer">
		<h1 style = "text-align: center">My Projects</h1>
					
			<table>
				 <c:forEach items="${projects}" var="project">
					<tr class = "projectRow">
						<td class = "title">${project.title}</td>
						<td><input type="Submit" name="${project.projectID}" value="View" /></td>
						</tr>
				</c:forEach>
			</table>
			
			<input type="Submit" name="submithome" value="Load My Projects" class = "button button5">
	</div>
	</form>
</body>
</html>