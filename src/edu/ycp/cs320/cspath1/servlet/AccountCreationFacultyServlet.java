package edu.ycp.cs320.cspath1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.enums.UserType;
import edu.ycp.cs320.cspath1.user.Faculty;



public class AccountCreationFacultyServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/accountCreationFaculty.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String errorMessage = null;
		Faculty faculty = new Faculty();
		
			//All required fields for faculty account
		String email = req.getParameter("email");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String password1 = req.getParameter("password1");
		MajorType majortype = getMajorTypeFromParameter(req.getParameter("majortype"));
			
		faculty.setEmail(email);
		faculty.setPassword(password);
		faculty.setUsername(username);
		faculty.setMajor(majortype);
		faculty.setUsertype(UserType.FACULTY);
			
			
		if (username == null || password == null || password1 == null || email == null || majortype == null) {
			errorMessage = "Please specify required fields";
		} else if (password != password1) {
			errorMessage = "Passwords do not match";
		}
		
		
		// Add parameters as request attributes
		req.setAttribute("username", req.getParameter("username"));
		req.setAttribute("password", req.getParameter("password"));
		req.setAttribute("email", req.getParameter("email"));
		req.setAttribute("majortype", req.getParameter("majortype"));
		req.setAttribute("password1", req.getParameter("password1"));
		
		
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		
		
		// Forward to view to render the result HTML document
		if (req.getParameter("business") != null){
			resp.sendRedirect(req.getContextPath() + "/accountCreationBusiness");
		}
		else if (req.getParameter("student") != null){
			resp.sendRedirect(req.getContextPath() + "/accountCreationStudent");
		}
		else if (req.getParameter("submit") != null) {
			resp.sendRedirect(req.getContextPath() + "/facultyHome");
		} else {
			req.getRequestDispatcher("/_view/accountCreationFaculty.jsp").forward(req, resp);
		}
	}
	
	//translate parameter to MajorType
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