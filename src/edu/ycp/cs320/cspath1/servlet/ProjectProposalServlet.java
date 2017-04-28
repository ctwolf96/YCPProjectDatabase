package edu.ycp.cs320.cspath1.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.enums.ProjectType;
import edu.ycp.cs320.cspath1.enums.SolicitationType;
import edu.ycp.cs320.cspath1.model.ProjectModel;
import edu.ycp.cs320.cspath1.controller.InsertProjectController;

public class ProjectProposalServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
//		String user = (String) req.getSession().getAttribute("user");
//		if (user == null) {
//			System.out.println("   User: <" + user + "> not logged in or session timed out");
//			
//			// user is not logged in, or the session expired
//			resp.sendRedirect(req.getContextPath() + "/login");
//			return;
//		}

		// now we have the user's User object,
		// proceed to handle request...
		
		//System.out.println("   User: <" + user + "> logged in");
		
		req.getRequestDispatcher("/_view/projectProposal.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String errorMessage = null;
		String successMessage = null;
		ProjectModel model = new ProjectModel();
		
		

		//All fields needed for project solicitation
		String solicit =req.getParameter("solicit");
		String strduration = req.getParameter("duration");
		String startTime = req.getParameter("startTime");
		String title = req.getParameter("title");
		String description= req.getParameter("description");
		//Until we make a model, these will be considered unused
		ArrayList <MajorType> majortypes = getMajorTypesFromParameters(req, resp);
		ArrayList <ClassType> classtypes = getClassTypesFromParameters(req, resp);
		int numStudents = Integer.parseInt(req.getParameter("numStudents"));
		Boolean isFunded = getBooleanFromParameter(req.getParameter("isFunded"));
		String struserID = req.getParameter("userID");
		int cost = Integer.parseInt(req.getParameter("cost"));
		SolicitationType solicitType = getSolicitTypeFromParameter(req.getParameter("solicitType"));
		String deadline = req.getParameter("endDate");
			
		model.setTitle(title);
		model.setStartTime(startTime);
		model.setDuration(strduration);
		model.setDescription(description);
		model.setClasses(classtypes);
		model.setMajors(majortypes);
		
		/*I had to hard code the boolea for the "isFunded" variable because
		the program would crash. Some reason it was reading the input from
		is funded as null*/
		
		
		model.setFunded(true);
		model.setNumStudents(numStudents);
		//Placeholder until I get all fields down
			if (title 		 == null || title.equals("") ||
				description  == null || description.equals("")  ||
				startTime    == null || startTime.equals("")     ||
				strduration     == null || strduration.equals("") ||
				struserID 	 == null || struserID.equals("")) {
				
				errorMessage = "Please fill in all of the required fields";
			}else {
				InsertProjectController controller = new InsertProjectController();
				
				//convert userID into a int for the controller
				int userID = Integer.parseInt(struserID);
				int duration = Integer.parseInt(strduration);
				
				try {
					if(controller.insertProjectIntoDatabase(userID, title, description, startTime, duration, ProjectType.PROPOSAL, solicitType,
						majortypes, classtypes, numStudents, (double)cost, isFunded, deadline)){
						successMessage = title;
					}
					else{
						errorMessage = "Failed to sumbit project"+title;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		// Add parameters as request attributes
		//Pretty certain this is used to put things into a model or controller
		req.setAttribute("duration", req.getParameter("duration"));
		req.setAttribute("startTime", req.getParameter("startTime"));
		req.setAttribute("title", req.getParameter("title"));
		req.setAttribute("description", req.getParameter("description"));
		
		
		
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("model", model);
	
		
		// Forward to view to render the result HTML document
		
		if (req.getParameter("solicit") != null){
			resp.sendRedirect(req.getContextPath() + "/projectSolicitation");
		}
		else if(req.getParameter("submit") != null){
			resp.sendRedirect(req.getContextPath() + "/sampleProject");
		}
		else {
		req.getRequestDispatcher("/_view/projectProposal.jsp").forward(req, resp);
		}
	}
	
	//Translate parameter to MajorType
	private MajorType getMajorTypeFromParameter(String s){
		MajorType majortype = null;
		if (s == null || s.equals("")){
			return null;
		}
		else if (s.equals("ME")){
			majortype = MajorType.ME;
			
		}
		else if (s.equals("CE")){
			majortype = MajorType.CE;
		}
		else if(s.equals("CS")){
			majortype = MajorType.CS;
		}
		else if(s.equals("EE")){
			majortype = MajorType.EE;
		}
		return majortype;
	}
	
	//Translate parameter to ClassType
	private ClassType getClassTypeFromParameter(String s){
		ClassType classtype = null;
		if(s == null || s.equals("")){
			return null;
		}
		else if (s == "FRESHMAN"){
			classtype = ClassType.FRESHMAN;
		}
		else if (s == "SOPHOMORE"){
			classtype = ClassType.SOPHOMORE;
		}
		else if (s == "JUNIOR"){
			classtype = ClassType.JUNIOR;
		}
		else if (s == "SENIOR"){
			classtype = ClassType.SENIOR;
		}
		return classtype;
	}
	
	private Boolean getBooleanFromParameter(String s){
		if (s == null || s.equals("")){
			return null;
		}
		else {
			return Boolean.parseBoolean(s);
		}
	}
	
	private ArrayList <MajorType> getMajorTypesFromParameters(HttpServletRequest req, HttpServletResponse resp){
		MajorType CE = getMajorTypeFromParameter("CE");
		MajorType CS = getMajorTypeFromParameter("CS");
		MajorType EE = getMajorTypeFromParameter("ME");
		MajorType ME = getMajorTypeFromParameter("EE");
		ArrayList <MajorType> majortypes = new ArrayList <MajorType>();
		if (CE != null){
			majortypes.add(CE);
		}
		if (CS != null){
			majortypes.add(CS);
		}
		if (EE != null){
			majortypes.add(EE);
		}
		if (ME != null){
			majortypes.add(ME);
		}
		
		return majortypes;
		
	}
	
	private ArrayList <ClassType> getClassTypesFromParameters(HttpServletRequest req, HttpServletResponse resp){
		ClassType FR = getClassTypeFromParameter("FRESHMAN");
		ClassType SO = getClassTypeFromParameter("SOPHOMORE");
		ClassType JR = getClassTypeFromParameter("JUNIOR");
		ClassType SR = getClassTypeFromParameter("SENIOR");
		ArrayList <ClassType> classtypes = new ArrayList <ClassType>();
		if (FR != null){
			classtypes.add(FR);
		}
		if (SO != null){
			classtypes.add(SO);
		}
		if (JR != null){
			classtypes.add(JR);
		}
		if (SR != null){
			classtypes.add(SR);
		}
		return classtypes;
	}
	
	private SolicitationType getSolicitTypeFromParameter(String s){
		SolicitationType solicitType = null;
		if(s == null || s.equals("")){
			return null;
		}
		else if (s == "ME_CAPSTONE"){
			solicitType = SolicitationType.ME_CAPSTONE;
		}
		else if (s == "ECE_CAPSTONE"){
			solicitType = SolicitationType.ECE_CAPSTONE;
		}
		else if (s == "CivE_CAPSTONE"){
			solicitType = SolicitationType.CivE_CAPSTONE;
		}
		else if (s == "ME_ECE_CAPSTONE"){
			solicitType = SolicitationType.ME_ECE_CAPSTONE;
		}
		else if (s == "SW_ENGINEERING"){
			solicitType = SolicitationType.SW_ENGINEERING;
		}
		else if (s == "CS_SENIOR_DESIGN_I"){
			solicitType = SolicitationType.CS_SENIOR_DESIGN_I;
		}
		else if (s == "CS_SENIOR_DESIGN_II"){
			solicitType = SolicitationType.CS_SENIOR_DESIGN_II;
		}
		else if (s == "INDEPENDENT_STUDY"){
			solicitType = SolicitationType.INDEPENDENT_STUDY;
		}
		else if (s == "CS_INTERNSHIP"){
			solicitType =SolicitationType.CS_INTERNSHIP;
		}
		else if (s == "ENGINEERING_COOP"){
			solicitType = SolicitationType.ENGINEERING_COOP;
		}
		else if (s == "CLASS_PROJECT"){
			solicitType = SolicitationType.CLASS_PROJECT;
		}
		return solicitType;
	}
}
