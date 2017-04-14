package edu.ycp.cs320.cspath1.servlet.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BusinessHomeAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//TODO: Add things for the radio parameters
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//doRequest(req, resp);
	}
	
	/*@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doRequest(req, resp);
	}

	private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get parameters
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		// Check whether parameters are valid
		if (username == null || password == null || email == null) {
			badRequest("Bad parameters", resp);
			return;
		}
		
		// Send back a response
		resp.setContentType("text/plain");
		resp.getWriter().println("Username: " + username);
		resp.getWriter().println("Password: " + password);
		resp.getWriter().println("Email: " + email);
	}

	

	private void badRequest(String message, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		resp.getWriter().println(message);
	}*/
}
