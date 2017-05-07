package edu.ycp.cs320.cspath1.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.cspath1.controller.UserController;
import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.enums.UserType;
import edu.ycp.cs320.cspath1.model.AccountCreationModel;
import edu.ycp.cs320.cspath1.persist.DatabaseProvider;
import edu.ycp.cs320.cspath1.persist.IDatabase;
import edu.ycp.cs320.cspath1.persist.YCPDatabase;
import edu.ycp.cs320.cspath1.user.User;

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
			AccountCreationModel model = new AccountCreationModel();
			UserController controller = new UserController();
			String errorMessage = null;
			
			String email = req.getParameter("email");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String password1 = req.getParameter("password1");
			MajorType majortype = getMajorTypeFromParameter(req.getParameter("majortype"));
			ClassType classtype = null;
			String firstname = req.getParameter("firstname");
			String lastname = req.getParameter("lastname");
			String name = null;
			String number = null;
			String address = null;
			
			model.setEmail(email);
			model.setUsername(username);
			model.setPassword(password1);
			model.setName(name);
			model.setAddress(address);
			model.setContactNum(number);
			model.setUsertype(UserType.FACULTY);
			model.setMajortype(majortype);
			model.setClasstype(classtype);
			model.setFirstName(firstname);
			model.setLastName(lastname);
			controller.setModel(model);
			
			int user_id = 0;
			User user = null;
				
			if (username == null || password == null || password1 == null || email == null || majortype == null || firstname == null || lastname == null) {
				errorMessage = "Please specify required fields";
			} else if (!password.equals(password1)) {
				errorMessage = "Passwords do not match";
			} else {
				try {
					user_id = controller.createAcct();
					user = controller.login();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// Add result objects as request attributes
			req.setAttribute("errorMessage", errorMessage);
			
			//See if the user clicked either of the other account types, redirect accordingly
			if (req.getParameter("business") != null){
				resp.sendRedirect(req.getContextPath() + "/accountCreationBusiness");
			}
			else if (req.getParameter("student") != null){
				resp.sendRedirect(req.getContextPath() + "/accountCreationStudent");
			}
			else if(req.getParameter("submit") != null && user_id > 0){
				req.getSession().setAttribute("user", user);
				resp.sendRedirect(req.getContextPath() + "/facultyHome");
			}
			else {
				req.getRequestDispatcher("/_view/accountCreationFaculty.jsp").forward(req, resp);
			}
		}
		
		//Translate parameter to MajorType
		private MajorType getMajorTypeFromParameter(String s){
			MajorType majortype = null;
			if (s == null || s.equals("")) {
				return null;
			}
			else if (s.equals("ME")) {
				majortype = MajorType.ME;
			}
			else if (s.equals("CE")) {
				majortype = MajorType.CE;
			}
			else if(s.equals("CS")) {
				majortype = MajorType.CS;
			}
			else if(s.equals("EE")) {
				majortype = MajorType.EE;
			}
			else if (s.equals("CIV")) {
				majortype = MajorType.CIV;
			}
			else if (s.equals("UN")) {
				majortype = MajorType.UN;
			}
			return majortype;
		}
}