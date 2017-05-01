<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>

<title>View Project</title>
<link rel="stylesheet" href="TestCSS.css">
</head>

<body>
	<c:if test="${! empty errorMessage}">
		<div class="error">${errorMessage}</div>
	</c:if>

	<h1 id="webpageTitle">View Project</h1>


	<div id="loginPart">
		<h3 id="webpageSubtitle">List of Projects</h3>
		<ul>
			<form action="${pageContext.servletContext.contextPath}/viewProjects"
				method="post">
				<li><input value="YCP Project Database" type="submit"
					name="ycpProject"></li>
			</form>
			<li>York City Bridge Design</li>
			<li>"Ted Talks" Video & Speech Review</li>
		</ul>
	</div>
</body>
</html>