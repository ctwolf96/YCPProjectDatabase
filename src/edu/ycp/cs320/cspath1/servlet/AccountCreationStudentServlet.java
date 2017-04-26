package edu.ycp.cs320.cspath1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.enums.UserType;
import edu.ycp.cs320.cspath1.model.AccountCreationModel;



public class AccountCreationStudentServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String user = (String) req.getSession().getAttribute("username");
		if (user == null) {
			System.out.println("   User: <" + user + "> not logged in or session timed out");
			
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		// now we have the user's User object,
		// proceed to handle request...
		
		System.out.println("   User: <" + user + "> logged in");
		
		req.getRequestDispatcher("/_view/accountCreationStudent.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String errorMessage = null;
		AccountCreationModel model = new AccountCreationModel();
		
		
		String email = req.getParameter("email");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		MajorType majortype = getMajorTypeFromParameter(req.getParameter("majortype"));
		ClassType classtype = getClassTypeFromParameter(req.getParameter("classtype"));
			
		model.setEmail(email);
		model.setPassword(password);
		model.setUsername(username);
		model.setMajortype(majortype);
		model.setUsertype(UserType.FACULTY);
		model.setClasstype(classtype);
			
		if (username == null || password == null || email == null || majortype == null || classtype == null) {
				errorMessage = "Please specify required fields";
		}
			
		
		// Add parameters as request attributes
		req.setAttribute("username", req.getParameter("username"));
		req.setAttribute("password", req.getParameter("password"));
		req.setAttribute("email", req.getParameter("email"));
		req.setAttribute("classtype", req.getParameter("classtype"));
		req.setAttribute("majortype", req.getParameter("majortype"));
		
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("model", model);
		
		//See if the user clicked either of the other account types, redirect accordingly
		if (req.getParameter("guest") != null){
			resp.sendRedirect(req.getContextPath() + "/accountCreationBusiness");
		}
		else if (req.getParameter("faculty") != null){
			resp.sendRedirect(req.getContextPath() + "/accountCreationFaculty");
		}
		else if(req.getParameter("submit") != null){
			resp.sendRedirect(req.getContextPath() + "/studentHome");
		}
		else {
			req.getRequestDispatcher("/_view/accountCreationStudent.jsp").forward(req, resp);
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
	

}