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
import edu.ycp.cs320.cspath1.enums.UserType;
import edu.ycp.cs320.cspath1.model.Pair;
import edu.ycp.cs320.cspath1.persist.DatabaseProvider;
import edu.ycp.cs320.cspath1.persist.IDatabase;
import edu.ycp.cs320.cspath1.persist.YCPDatabase;
import edu.ycp.cs320.cspath1.project.Project;
import edu.ycp.cs320.cspath1.user.User;

public class MyProjectsServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
private IDatabase db;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = (String) req.getSession().getAttribute("username");
		String password = (String) req.getSession().getAttribute("password");
		if (username == null || password == null)
		{
			req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		} else {
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
		int user_id = 0;
		String username = (String) req.getSession().getAttribute("username");
		String password = (String) req.getSession().getAttribute("password");

		try {
			user_id = db.findUserIDByUsernameAndPassword(username, password);
			userProjects = db.findAllProjectsByUser(user_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		projects = new ArrayList<Project>();
		for (Pair<User, Project> userProject : userProjects) {
			User user = userProject.getLeft();
			Project project = userProject.getRight();
			projects.add(project);
		}
		
		if (projects.isEmpty()) {
			errorMessage = "This user currently has no projects";
		}
		
		// Add result objects as request attributes
				req.setAttribute("errorMessage", errorMessage);
				req.setAttribute("projects",  projects);
				
				// Forward to view to render the result HTML document
				req.getRequestDispatcher("/_view/myProjects.jsp").forward(req, resp);
	}
}
