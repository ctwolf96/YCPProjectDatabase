<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>

<title>Sample Project</title>
<link rel="stylesheet" href="TestCSS.css">
</head>

<body>
	<c:if test="${! empty errorMessage}">
		<div class="error">${errorMessage}</div>
	</c:if>
	<form action="${pageContext.servletContext.contextPath}/sampleProject"
		method="post">

		<h1 id="webpageTitle">YCP Database</h1>


		<div id="loginPart">
			<h3 id="sectionSubtitle">Description</h3>
			<p>Creation for a website to share, view, accept and create
				projects for the York college community</p>
			<h3 id="sectionSubtitle">Hardware?</h3>
			<p>No</p>
			<h3 id="sectionSubtitle">Software</h3>
			<p>Yes</p>
			<h3 id="sectionSubtitle">Funding</h3>
			<p>No</p>
			<h3 id="sectionSubtitle">Duration</h3>
			<p>1 Semester</p>
			<h3 id="sectionSubtitle">Major/Disciplines</h3>
			<ul>
				<li>Computer Engineering</li>
				<li>Computer Science</li>
			</ul>
			<div class="search">
				<input name="search" type="submit" value="Search Projects">
			</div>
			<h3 id="sectionSubtitle">Student Class</h3>
			<p>Sophomores</p>
		</div>
	</form>
</body>
</html>