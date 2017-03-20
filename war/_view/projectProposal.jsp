<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Project Solicitation</title>
		<link rel="stylesheet" href="TestCSS.css">
	</head>
	
	<body>
	<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
	</c:if>
	
	<h1 id="webpageTitle">Project Name</h1>
	
	
	<div id="loginPart">
	<h3 id="webpageSubtitle">Project Information</h3>
	<form action="${pageContext.servletContext.contextPath}/projectSolicitation" method="post">
	
		<p>Hardware?</p>
		<p>Yes/No</p>
		
		<p>Software?</p>
		<p>Yes/No</p>
		
			<table>
				<tr>
					<td class="label">Duration of Project (# of semesters):</td>
					<td>(Duration of the Project)</td>
				</tr>
				<tr>
					<td class="label">Start Time:</td>
					<td>(Start Date of Project)</td>
				</tr>
			</table>
			<br>
			
			<p>Majors/Disciplines: </p>
			<ul>
				<li>(List of desired majors)</li>
			
			</ul> 
			
			<p>Student Class</p>
			<ul>
				<li>(List of desired Grades)</li>			
			</ul>			
		</form>
		</div>
	</body>
</html>