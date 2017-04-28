<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>

<title>Project Proposal</title>
<link rel="stylesheet" href="ProposalPage.css">
<meta name="viewport" content="width = device-width initial-scale =1">

</head>

<body>
	<div id="header">
		<div id="logo">
			<img src="Logo.png">
		</div>
	</div>
	<c:if test="${! empty errorMessage}">
		<div class="error">${errorMessage}</div>
	</c:if>




	<div class="superContainer">
		<form
			action="${pageContext.servletContext.contextPath}/projectProposal"
			method="post">
			<h1 style="text-align: center">Project Proposal</h1>
			<label><a>Project Title:</a></label><br> <input type="text"
				name="title"><br>
			<br> <label><a>Description:</a></label>
			<textarea name="message" class="description" rows="10" cols="30">
		</textarea>
			<br>
			<br> <label><a>Duration (Semesters):</a></label><br> <select
				name="duration">
				<option value="1" selected>1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
			</select><br>
			<br> <label><a>Start Date:</a></label><br> <input
				type="date" name="startTime"><br>
			<br> <label><a>Deadline:</a></label><br> <input type="date"
				name="endDate"><br>
			<br> <label><a>Funding:</a></label><br> <select
				name="isFunded">
				<option value="true" selected>Yes</option>
				<option value="false">No</option>
			</select><br>
			<br> <labeL><a>Number of Students:</a></labeL><br> <input
				type="number" name="numStudents" min="1"><br>
			<br> <labeL><a>Majors Involved</a></labeL><br> <input
				type="checkbox" name="CE" value="CE">Computer Engineering <input
				type="checkbox" name="CS" value="CS">Computer Science <input
				type="checkbox" name="EE" value="EE">Electrical Engineering
			<input type="checkbox" name="CivE" value="CivE">Civil
			Engineering <input type="checkbox" name="ME" value="ME">Mechanical
			Engineering<br>
			<br> <labeL><a>Solicitation Type</a></labeL><br> <input
				type="radio" name="solicitType" value="ME_CAPSTONE">ME_CAPSTONE
			<input type="radio" name="solicitType" value="ECE_CAPSTONE">ECE_CAPSTONE
			<input type="radio" name="solicitType" value="CivE_CAPSTONE">CivE_CAPSTONE
			<input type="radio" name="solicitType" value="ME_ECE_CAPSTONE">ME_ECE_CAPSTONE
			<input type="radio" name="solicitType" value="SW_ENGINEERING">SW_ENGINEERING
			<input type="radio" name="solicitType" value="CS_SENIOR_DESIGN_I">CS_SENIOR_DESIGN_I
			<input type="radio" name="solicitType" value="CS_SENIOR_DESIGN_II">CS_SENIOR_DESIGN_II
			<input type="radio" name="solicitType" value="INDEPENDENT_STUDY">INDEPENDENT_STUDY
			<input type="radio" name="solicitType" value="CS_INTERNSHIP">CS_INTERNSHIP
			<input type="radio" name="solicitType" value="ENGINEERING_COOP">ENGINEERING_COOP
			<input type="radio" name="solicitType" value="CLASS_PROJECT">CLASS_PROJECT<br>
			<br> <label><a>Student Year(s)</a></label><br> <input
				type="checkbox" name="freshman" value="FR">Freshman <input
				type="checkbox" name="sophomore" value="SO">Sophomore <input
				type="checkbox" name="junior" value="JR">Junior <input
				type="checkbox" name="senior" value="SR">Senior<br>
			<br> <label><a>Cost:</a></label><br> <input type="text"
				name="cost"><br>
			<br>

			<div>
				<input type="Submit" name="submit" value="Create Project"
					class="button button5"> <input type="Submit" name="solicit"
					value="Solicit Project Form" class="button button5">
			</div>

		</form>
	</div>
</body>
</html>