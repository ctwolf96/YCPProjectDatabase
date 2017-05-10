package edu.ycp.cs320.cspath1.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.cspath1.controller.ProjectSettingsController;
import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.model.ProjectModel;
import edu.ycp.cs320.cspath1.project.Project;
import edu.ycp.cs320.cspath1.user.User;

public class ProjectSettingsProposalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		Project project = (Project) req.getSession().getAttribute("project");
		if (user == null || project == null)
		{
			req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("/_view/projectSettingsProposal.jsp").forward(req, resp);
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		Project project = (Project) req.getSession().getAttribute("project");
		ProjectSettingsController controller = new ProjectSettingsController();
		ProjectModel model = new ProjectModel();
		//Fields to load into database
		String newTitle = req.getParameter("title");
		String newDescription = req.getParameter("description");
		String newStart = req.getParameter("start");
		String newNumStudents = req.getParameter("numStudents");
		String cost = req.getParameter("cost");
		String duration = req.getParameter("duration");
		String[] Majors = req.getParameterValues("majors");
		String[] Classes = req.getParameterValues("classes");
		ArrayList<MajorType> majors = new ArrayList<MajorType>();
		ArrayList<ClassType> classes = new ArrayList<ClassType>();
		String funding = req.getParameter("funding");
		String deadline = req.getParameter("deadline");
		
		if (!(Majors == null)) {
			for (int i = 0; i < Majors.length; i++) {
				majors.add(getMajorTypeFromParameter(Majors[i]));
			}
		}
		if (!(Classes == null)) {
			for(int i = 0; i < Classes.length;i++) {
				classes.add(getClassTypeFromParameter(Classes[i]));
			}
		}
		
		//Populate Model and controller
		model.setTitle(newTitle);
		model.setDescription(newDescription);
		model.setStartTime(newStart);
		model.setDeadline(deadline);
		model.setProject_id(project.getProjectID());
		if (!newNumStudents.equals("")) {
			model.setNumStudents(Integer.parseInt(newNumStudents));
		}
		if (!cost.equals("")) {
			model.setCost(Double.parseDouble(cost));
		}
		if (!duration.equals("")) {
			model.setDuration(Integer.parseInt(duration));
		}
		model.setMajors(majors);
		model.setClasses(classes);
		System.out.println("funding: " + funding);
		if(funding == null){
			funding = "false";
		}
		if (!funding.equals("") || funding != null) {
			if (funding.equals("true")) {
				model.setFunded(true);
			} else {
				model.setFunded(false);
			}
		}
		controller.setModel(model);
		
		
		if (req.getParameter("changeTitle") != null && newTitle != null) {
			try {
				System.out.println("new Title: " + newTitle);
				controller.editTitle();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (req.getParameter("changeDescription") != null && newDescription != null) {
			try {
				controller.editDescription();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (req.getParameter("changeStartDate") != null) {
			try {
				controller.editStart();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (req.getParameter("changeCost") != null) {
			try {
				controller.editCost();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (req.getParameter("changeDuration") != null) {
			try {
				controller.editDuration();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (req.getParameter("changeMajor") != null) {
			try {
				controller.editMajors();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (req.getParameter("changeNumStudents") != null) {
			try {
				controller.editNumStudents();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (req.getParameter("changeFunding") != null) {
			try {
				controller.editFunding();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (req.getParameter("changeDeadline") != null) {
			try {
				controller.editDeadline();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (req.getParameter("done") != null) {
			resp.sendRedirect(req.getContextPath() + "/myProjects");
		}
		else {
			req.getRequestDispatcher("/_view/projectSettingsProposal.jsp").forward(req, resp);
		}
		
	}
	
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
		else if (s.equals("FRESHMAN")){
			classtype = ClassType.FRESHMAN;
		}
		else if (s.equals("SOPHOMORE")){
			classtype = ClassType.SOPHOMORE;
		}
		else if (s.equals("JUNIOR")){
			classtype = ClassType.JUNIOR;
		}
		else if (s.equals("SENIOR")){
			classtype = ClassType.SENIOR;
		}
		return classtype;
	}
}
