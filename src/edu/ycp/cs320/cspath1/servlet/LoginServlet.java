package edu.ycp.cs320.cspath1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.cspath1.model.AccountCreationModel;



public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String errorMessage = null;
		AccountCreationModel model = new AccountCreationModel();

		
		

		String username = req.getParameter("username");
		String password = req.getParameter("password");
			
		req.getSession().setAttribute("username", username);
		req.getSession().setAttribute("password", password);
		
		model.setUsername(username);
		model.setPassword(password);
			
		if (username == null || password == null) {
			errorMessage = "Please specify username and password";
		}
			
		
		
		// Add parameters as request attributes
		req.setAttribute("username", req.getParameter("username"));
		req.setAttribute("password", req.getParameter("password"));
		
		
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("model", model);
		

		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/studentHome.jsp").forward(req, resp);
	}
	
	

}
