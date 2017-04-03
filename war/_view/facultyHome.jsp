<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Home</title>
		<link rel="stylesheet" href="TestCSS.css">
	</head>
	
	<body>
	<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
	</c:if>
	
	<h1 id="webpageTitle">Home</h1>
	
	<div id="Context">
		<div class= "info"> 
			<h4 id="Info">
			<p>Discipline/Disciplines</p>
				<p>email</p>
			</h4>
		</div>
		<div class= "sections">
		<h3 id="sectionSubtitle">Projects</h3>
		<form action= "${pageContext.servletContext.contextPath}/studentHome" method="post">
			<input name = "projectSolicitation" type= "submit" value="Project Search"/>
			<input name="projectProposal" type="submit" value="Project Proposal" />
		</form>
			<ul>
				<li>Project 1</li>
				<li>Project 2</li>
				<li>Project 3</li>
			</ul>
		</div>
	</div>
	</body>
</html>