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

import edu.ycp.cs320.cspath1.model.ProjectModel;
import edu.ycp.cs320.cspath1.controller.InsertProjectController;

public class UserSearchServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String user = (String) req.getSession().getAttribute("user");
//		if (user == null) {
//			System.out.println("   User: <" + user + "> not logged in or session timed out");
//			
//			// user is not logged in, or the session expired
//			resp.sendRedirect(req.getContextPath() + "/login");
//			return;
//		}

		// now we have the user's User object,
		// proceed to handle request...
		
		System.out.println("   User: <" + user + "> logged in");
		
		req.getRequestDispatcher("/_view/userSearch.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		MajorType majorType = getMajorTypeFromParameter(req.getParameter("major"));
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
}
