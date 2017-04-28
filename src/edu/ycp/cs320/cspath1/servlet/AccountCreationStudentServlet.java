 package edu.ycp.cs320.cspath1.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.enums.UserType;
import edu.ycp.cs320.cspath1.persist.DatabaseProvider;
import edu.ycp.cs320.cspath1.persist.IDatabase;
import edu.ycp.cs320.cspath1.persist.YCPDatabase;
import edu.ycp.cs320.cspath1.user.Student;



public class AccountCreationStudentServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
private IDatabase db;	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/accountCreationStudent.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		DatabaseProvider.setInstance(new YCPDatabase());
		db = DatabaseProvider.getInstance();	
		String errorMessage = null;
		
		String email = req.getParameter("email");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String password1 = req.getParameter("password1");
		MajorType majortype = getMajorTypeFromParameter(req.getParameter("majortype"));
		ClassType classtype = getClassTypeFromParameter(req.getParameter("classtype"));
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String address = null;
		String contactNum = null;
		String name = null;
			
		if (username == null || password == null || password1 == null || email == null || majortype == null || classtype == null|| firstName==null || lastName==null) {
			errorMessage = "Please specify required fields";
		} else if (password != password1) {
			errorMessage = "Passwords do not match";
		} else {
			try {
				db.insertUser(username, password1, email, UserType.STUDENT, firstName, lastName, majortype,
						classtype, name, address, contactNum);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
		
		// Add parameters as request attributes
		req.setAttribute("username", req.getParameter("username"));
		req.setAttribute("password", req.getParameter("password"));
		req.setAttribute("email", req.getParameter("email"));
		req.setAttribute("classtype", req.getParameter("classtype"));
		req.setAttribute("majortype", req.getParameter("majortype"));
		req.setAttribute("password1", req.getParameter("password1"));
		req.setAttribute("firstName", req.getParameter("firstName"));
		req.setAttribute("lastName", req.getParameter("lastName"));
		req.setAttribute("address", req.getParameter("address"));
		req.setAttribute("contactNum", req.getParameter("contactNum"));
		req.setAttribute("name", req.getParameter("name"));
		
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		
		//See if the user clicked either of the other account types, redirect accordingly
		if (req.getParameter("business") != null){
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