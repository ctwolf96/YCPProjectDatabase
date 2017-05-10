package edu.ycp.cs320.cspath1.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.cspath1.controller.SearchProjects;
import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.enums.SolicitationType;
import edu.ycp.cs320.cspath1.enums.UserType;
import edu.ycp.cs320.cspath1.project.Project;
import edu.ycp.cs320.cspath1.user.User;

public class SolicitationSearchServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

	private SearchProjects search = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		if (user == null)
		{
			req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("/_view/solicitationSearch.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		User user = (User) req.getSession().getAttribute("user");
		
		if (req.getParameter("logout") != null) {
			req.getSession().invalidate();
			resp.sendRedirect(req.getContextPath() + "/login");
		} else if (req.getParameter("userSearch") != null) {
			resp.sendRedirect(req.getContextPath() + "/userSearch");
		} else if (req.getParameter("proposalSearch") != null) {
			resp.sendRedirect(req.getContextPath() + "/proposalSearch");
		} else if (req.getParameter("solicitationSearch") != null) {
			resp.sendRedirect(req.getContextPath() + "/solicitationSearch");
		} else if (req.getParameter("solicitation") != null) {
			resp.sendRedirect(req.getContextPath() + "/projectSolicitation");
		} else if (req.getParameter("proposal") != null) {
			resp.sendRedirect(req.getContextPath() + "/projectProposal");
		} else if (req.getParameter("myProjects") != null) {
			resp.sendRedirect(req.getContextPath() + "/myProjects");
		} else if (req.getParameter("settings") != null) {
			resp.sendRedirect(req.getContextPath() + "/userSettingsStudent");
		} else if (req.getParameter("home") != null && user.getUsertype().equals(UserType.STUDENT)) {
			resp.sendRedirect(req.getContextPath() + "/studentHome");
		} else if (req.getParameter("home") != null && user.getUsertype().equals(UserType.FACULTY)) {
			resp.sendRedirect(req.getContextPath() + "/facultyHome");
		} else if (req.getParameter("home") != null && user.getUsertype().equals(UserType.BUSINESS)) {
			resp.sendRedirect(req.getContextPath() + "/businessHome");
		}
		
		Project project			 	=null;
		ArrayList<Project> projects	=null;
		String searchField 			=null;
		String errorMessage			=null;
		String title				=null;
		String description			=null;
		String start				=null;
		//String deadline				=null;
		int duration;
		int numStudents;
		double cost;
		MajorType majorType			=null;
		ClassType classtype			=null;
		SolicitationType solicit	=null;
		boolean isFunded;
		
		
		searchField = req.getParameter("attribute");
		
		search = new SearchProjects();
		projects = new ArrayList<Project>();
		
		
		if(searchField.equals("title")){
			try {
				title = req.getParameter("keyword");
				projects= search.getProjectsByTitle(title);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(searchField.equals("description")){
			try {
				description = req.getParameter("keyword");
				projects = search.getProjectsByDescription(description);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(searchField.equals("start")){
			try {
				start = req.getParameter("keyword");
				projects = search.getProjectsByStart(start);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*else if(searchField.equals("deadline")){
			try {
				deadline = req.getParameter("keyword");
				projects = search.getProjectsByDeadline(deadline);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		else if(searchField.equals("major")){
			try {
				majorType = getMajorTypeFromParameter(req.getParameter("keyword"));
				projects.addAll(search.getProjectsByMajor(majorType));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(searchField.equals("class")){
			try {
				classtype = getClassTypeFromParameter(req.getParameter("keyword"));
				projects.addAll(search.getProjectsByClassType(classtype));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(searchField.equals("duration")){
			try {
				duration = Integer.parseInt(req.getParameter("keyword"));
				projects = search.getProjectsByDuration(duration);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(searchField.equals("numStudents")){
			try {
				numStudents = Integer.parseInt(req.getParameter("keyword"));
				projects = search.getProjectsByNumberOfStudents(numStudents);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(searchField.equals("cost")){
			try {
				cost = Integer.parseInt(req.getParameter("keyword"));
				projects = search.getProjectsByCost(cost);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(searchField.equals("isFunded")){
			try {
				isFunded = isFunded(req.getParameter("keyword"));
				projects = search.getProjectsByFunding(isFunded);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(searchField.equals("solicitationType")){
			try {
				solicit = getSolicitType(req.getParameter("keyword"));
				projects = search.getProjectsBySolicitationType(solicit);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (projects == null) {
			errorMessage = "User/Users not found in library";
		}
		else {
			project  = projects.get(0);
			System.out.println(project.getTitle());
		}
		req.setAttribute("projects", projects);
		req.setAttribute("project", project);
		req.setAttribute("errorMessage", errorMessage);
		
		req.getRequestDispatcher("/_view/proposalSearch.jsp").forward(req, resp);
	}
	
	private MajorType getMajorTypeFromParameter(String s){
		MajorType majortype = null;
		if (s == null || s.equals("")){
			return null;
		}
		else if (s.equals("ME")||s.equals("Mechanical")||s.equals("mechanical")||s.equals("mechanical engineering")){
			majortype = MajorType.ME;
			
		}
		else if (s.equals("CE")||s.equals("Computer")||s.equals("computer")||s.equals("Computer Engineering")||s.equals("computer engineering")||s.equals("Computer Engineering")){
			majortype = MajorType.CE;
		}
		else if(s.equals("CS")||s.equals("Computer Science")||s.equals("compter science")){
			majortype = MajorType.CS;
		}
		else if(s.equals("EE")||s.equals("Electrical")||s.equals("electrical")||s.equals("Electrical Engineering")||s.equals("Electrical engineering")||s.equals("electrical engineering")){
			majortype = MajorType.EE;
		}
		return majortype;
	}
	
	private ClassType getClassTypeFromParameter(String s){
		ClassType classtype = null;
		if (s == null || s.equals("")){
			return null;
		}
		else if (s.equals("sophomore")||s.equals("Sophomore")|| s.equals("SO")||s.equals("so")){
			classtype = ClassType.SOPHOMORE;
			
		}
		else if (s.equals("freshman")||s.equals("Freshman")||s.equals("FR")||s.equals("fr")){
			classtype = ClassType.FRESHMAN;
		}
		else if(s.equals("Senior")||s.equals("senior")||s.equals("SR")||s.equals("sr")){
			classtype = ClassType.SENIOR;
		}
		else if(s.equals("junior")||s.equals("Junior")||s.equals("JR")||s.equals("jr")){
			classtype = ClassType.JUNIOR;
		}
		return classtype;
	}
	private boolean isFunded(String s){
		if(s.equals("yes") || s.equals("Yes")||s.equals("YES")){
			return true;
		}
		else{
			return false;
		}
	}
	private SolicitationType getSolicitType(String s){
		SolicitationType solicit = null;
		if(s.equals("ME Capstone")||s.equals("Mechanical Capstone")){
			solicit = SolicitationType.ME_CAPSTONE;
		}
		else if(s.equals("ECE Capstone")||s.equals("Electrical Capstone")||s.equals("Computer Capstone")){
			solicit = SolicitationType.ECE_CAPSTONE;
		}
		else if(s.equals("Civ Capstone")||s.equals("Civil Capstone")||s.equals("civil Capstone")){
			solicit = SolicitationType.CivE_CAPSTONE;
		}
		else if(s.equals("ME ECE Capstone")||s.equals("Electrical Mechanical Capstone")||s.equals("Mechanical Electrical Capstone")){
			solicit = SolicitationType.ME_ECE_CAPSTONE;
		}
		else if(s.equals("Software Engineering")||s.equals("SW Eng")||s.equals("software engineering")){
			solicit = SolicitationType.SW_ENGINEERING;
		}
		else if(s.equals("CS Senior Design 1")||s.equals("cs Senior Design 1")||s.equals("CS Sen Design 1")){
			solicit = SolicitationType.CS_SENIOR_DESIGN_I;
		}
		else if(s.equals("CS Senior Design 2")||s.equals("cs Senior Design 2")||s.equals("CS Sen Design 2")){
			solicit = SolicitationType.CS_SENIOR_DESIGN_II;
		}
		else if(s.equals("Independant Study")||s.equals("Ind Study")||s.equals("independant study")){
			solicit = SolicitationType.INDEPENDENT_STUDY;
		}
		else if(s.equals("CS Internship")||s.equals("Computer engineering Internship")||s.equals("CS internship")){
			solicit = SolicitationType.CS_INTERNSHIP;
		}
		else if(s.equals("Engineering Co-op")||s.equals("engineering co-op")||s.equals("eng coop")){
			solicit = SolicitationType.ENGINEERING_COOP;
		}
		else if(s.equals("class project")||s.equals("Class project")||s.equals("Class Project")){
			solicit = SolicitationType.CLASS_PROJECT;
		}
		return solicit;
	}
}
