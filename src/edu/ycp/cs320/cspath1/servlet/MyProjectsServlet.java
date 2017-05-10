package edu.ycp.cs320.cspath1.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.enums.ProjectType;
import edu.ycp.cs320.cspath1.enums.UserType;
import edu.ycp.cs320.cspath1.model.Pair;
import edu.ycp.cs320.cspath1.persist.DatabaseProvider;
import edu.ycp.cs320.cspath1.persist.IDatabase;
import edu.ycp.cs320.cspath1.persist.YCPDatabase;
import edu.ycp.cs320.cspath1.project.Project;
import edu.ycp.cs320.cspath1.project.Proposal;
import edu.ycp.cs320.cspath1.user.User;

public class MyProjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IDatabase db;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			User user = (User) req.getSession().getAttribute("user");
			if (user == null)
			{
				req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
			}  else {
			req.getRequestDispatcher("/_view/myProjects.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{ 
		DatabaseProvider.setInstance(new YCPDatabase());
		db = DatabaseProvider.getInstance();	
		String errorMessage = null;
		List<Pair<User, Project>> userProjects = null;
		ArrayList<Project> projects = null;
		User user = (User) req.getSession().getAttribute("user");

		try {
			userProjects = db.findAllProjectsByUser(user.getUserID());
			projects = new ArrayList<Project>();
			System.out.println(user.getUserID());
			for (Pair<User, Project> userProject : userProjects) {
				System.out.println(userProject.getRight().getTitle());
				projects.add(userProject.getRight());
			}
			
			if (projects.isEmpty()) {
				errorMessage = "You currently have no projects";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("projects",  projects);
				
		// Forward to view to render the result HTML document
		for (Project project : projects) {
			if(req.getParameter(Integer.toString(project.getProjectID())) != null) {
				req.getSession().setAttribute("project", project);
				if (project.getProjectType().equals(ProjectType.PROPOSAL)) {
					resp.sendRedirect(req.getContextPath() + "/viewProject");
				}
				else if (project.getProjectType().equals(ProjectType.SOLICITATION)) {
					resp.sendRedirect(req.getContextPath() + "/viewSolicitation");
				}
				else {
					System.out.println("Something has gone horribly wrong...");
				}
			}
		}
		if(req.getParameter("submithome") != null) {
			req.getRequestDispatcher("/_view/myProjects.jsp").forward(req, resp);
		} else if (req.getParameter("logout") != null) {
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
		
		
		
	
	}
}
