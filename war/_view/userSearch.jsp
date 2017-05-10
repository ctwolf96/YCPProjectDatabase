<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
	<title>User Search</title>
	<link rel="stylesheet" href="Search.css">
	<meta name="viewport" content="width = device-width initial-scale=1">
</head>

	<body>
		<div id="header">
			<div id="logo">
				<img src="Logo.png">
			</div>
		
		<form action="${pageContext.servletContext.contextPath}/userSearch" method="post">
		
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
	<h1 style = "text-align: center">User Search</h1>
		<c:if test="${! empty errorMessage}">
			<div class="error" style = "text-align: center">${errorMessage}</div><br>
		</c:if>
	<div Style = "margin-left: 210px">
	

		<select name="attribute">
				<option value="username"selected>Username</option>
				<option value="email">Email</option>
				<option value="majortype">Major Type</option>
				<option value="classtype">Student Year</option>
				<option value="usertype">User Type</option>
				<option value="firstname">First Name</option>
				<option value="lastname">Last Name</option>
				<option value="name">Business Name</option>
				<option value="address">Business Address</option>
				<option value="number">Business Number</option><br>
				
		
		</select>
		&nbsp;
		<input type="text" name="keyword">
			
		<input type="Submit" name="submit" value="Search" class = "">
		<br><br><table style = "margin-left: 110px">
			 <c:forEach items="${users}" var="user">
				<tr class = "userRow">
					<td>${user.username}</td>
					<td><input type="Submit" name="${user.userID}" value="View" /></td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</div>
	</form>
	</body>
</html>