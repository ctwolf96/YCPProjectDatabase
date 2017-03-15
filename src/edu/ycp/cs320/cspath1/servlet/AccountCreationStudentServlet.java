package edu.ycp.cs320.cspath1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AccountCreationStudentServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/accountCreationStudent.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String errorMessage = null;
		String result = null;
		
		
		try {
			String email = req.getParameter("email");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			if (username == null || password == null || email == null) {
				errorMessage = "Please specify username, password, and email";
			}
			
			result = username + password;
		} catch (NumberFormatException e) {
			errorMessage = "Invalid double";
		}
		
		// Add parameters as request attributes
		req.setAttribute("username", req.getParameter("username"));
		req.setAttribute("password", req.getParameter("password"));
		req.setAttribute("email", req.getParameter("email"));
		
		
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("result", result);
		
		//See if the user clicked either of the other account types, redirect accordingly
		if (req.getParameter("guest") != null){
			resp.sendRedirect(req.getContextPath() + "/accountCreationGuest");
		}
		else if (req.getParameter("faculty") != null){
			resp.sendRedirect(req.getContextPath() + "/accountCreationFaculty");
		}
		else {
			req.getRequestDispatcher("/_view/accountCreationStudent.jsp").forward(req, resp);
		}
	}
	
	

}