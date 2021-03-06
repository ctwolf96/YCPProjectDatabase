<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<header>
	<title>Solicited Project Search</title>
	<link rel="stylesheet" href="Search.css">
	<meta name="viewport" content="width = device-width initial-scale=1">
	</head>

	<body>
	<form action="${pageContext.servletContext.contextPath}/solicitationSearch" method="post">
		<div id="header">
			<div id="logo">
				<img src="Logo.png">
			</div>
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
	
	<h1 style = "text-align: center">Solicited Project Search</h1>
	<c:if test="${! empty errorMessage}">
			<div class="error" style = "text-align: center">${errorMessage}</div><br>
		</c:if>
	<div style = "margin-left: 210px">
		<select name="attribue">
				<option value="title"selected>Title</option>
				<option value="description">Description</option>
				<option value="start">Start Date</option>
				<option value="duration">Duration</option>
				<option value="solicitationType">Solicitation Type</option>
				<option value="major">Major</option>
				<option value="class">Class</option>
				<option value="numStudents">Number of Students</option>
				<option value="isFunded">Funding Availability</option>
				<option value="cost">Cost</option>
		</select>
		<input type="text" name="keyword">
		<input type="Submit" name="submit" value="Search" class = "">
		<br><br><table style = "margin-left: 110px">
		<c:forEach items="${projects}" var="project">
				<tr class = "userRow">
					<td>${projects.title}</td>
					<td><input type="Submit" name="${project.projectID}" value="view" /></td>
				</tr>
			</c:forEach>
			</table>
		</form>
		</div>
		</div>
	</body>
</html>