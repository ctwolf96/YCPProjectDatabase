package edu.ycp.cs320.cspath1.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.enums.SolicitationType;
import edu.ycp.cs320.cspath1.model.ProjectModel;

import edu.ycp.cs320.cspath1.persist.FakeDatabase;
import edu.ycp.cs320.cspath1.project.Solicitation;

public class ProjectSolicitationServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/projectSolicitation.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String errorMessage = null;
		ProjectModel model = new ProjectModel();
		
		
		
	
			//All fields needed for project solicitation
		String project = req.getParameter("project");
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String duration = req.getParameter("duration");
		String startTime = req.getParameter("startTime");
		String password = req.getParameter("password");
		//String find = req.getParameter("submit");
			//Until we make a model, these will be considered unused
		ArrayList <MajorType> majortypes = getMajorTypesFromParameters(req, resp);
		ArrayList <ClassType> classtypes = getClassTypesFromParameters(req, resp);
			
		
		
		model.setClasses(classtypes);
		model.setMajors(majortypes);
		model.setTitle(title);
		model.setDescription(description);
		model.setDuration(duration);
		model.setStartTime(startTime);
		
		//Placeholder until I get all fields down
		if (duration==null && description==null && majortypes==null && classtypes==null && title==null && startTime==null) {
				errorMessage = "Please specify at least one field";
		}
			
		// Add parameters as request attributes
		//Pretty certain this is used to put things into a model or controller
		req.setAttribute("duration", req.getParameter("duration"));
		req.setAttribute("startTime", req.getParameter("startTime"));
		req.setAttribute("hardware", req.getParameter("hardware"));
		req.setAttribute("software", req.getParameter("software"));
		
		
		
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("model", model);
		
		// Forward to view to render the result HTML document
		if (project != null){
			resp.sendRedirect(req.getContextPath() + "/projectProposal");
		}
		else if(req.getParameter("submit")!= null){
			resp.sendRedirect(req.getContextPath() + "/viewProjects");
		}
		else{
			req.getRequestDispatcher("/_view/projectSolicitation.jsp").forward(req, resp);
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
	
	public ArrayList <ClassType> getClassTypesFromParameters(HttpServletRequest req, HttpServletResponse resp){
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
	
	public ArrayList<Solicitation> getFoundProjects(ClassType classtype){
		ArrayList<Solicitation> result = new ArrayList<Solicitation>();
		FakeDatabase fb = new FakeDatabase();
		//result.addAll(fb.findSolicitationsByMajorType(majortype));
		//result.addAll(fb.findSolicitationsByMajorTypes(majors));
		//result.addAll(fb.findSolicitationsByClassType(classtype));
		//result.addAll(fb.findSolicitationsByClassTypes(classtypes));
		//result.addAll(fb.findSolicitationsByStartTime(startTime));
		//result.addAll(fb.findSolicitationsByDuration(duration));
		//result.addAll(fb.findSolicitationsByNumStudents(numStudents));
		//result.addAll(fb.findSolicitationsBySolicitationType(solicitationType));
		//result.add(fb.findSolicitationByProjectID(projectID));
		return result;
	}
}
