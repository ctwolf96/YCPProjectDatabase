package edu.ycp.cs320.cspath1.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.cspath1.controller.SettingsController;
import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.model.AccountCreationModel;
import edu.ycp.cs320.cspath1.persist.DatabaseProvider;
import edu.ycp.cs320.cspath1.persist.IDatabase;
import edu.ycp.cs320.cspath1.persist.YCPDatabase;
import edu.ycp.cs320.cspath1.user.Student;
import edu.ycp.cs320.cspath1.user.User;

public class UserSettingsStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = (String) req.getSession().getAttribute("username");
		String password = (String) req.getSession().getAttribute("password");
		if(username == null || password == null) {
			req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("/_view/userSettingsStudent.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		SettingsController controller = new SettingsController();
		AccountCreationModel model  = new AccountCreationModel();
		
		String username = (String) req.getSession().getAttribute("username");
		String password = (String) req.getSession().getAttribute("password");
		int user_id = (int) req.getSession().getAttribute("user_id");
		String errorMessage = null;
		
		//Fields to load into database
		String newUsername = req.getParameter("username");
		String newPassword = req.getParameter("password");
		MajorType majortype = getMajorTypeFromParameter(req.getParameter("major"));
		ClassType classtype = getClassTypeFromParameter(req.getParameter("class"));
		
		//populate model
		model.setUsername(newUsername);
		model.setPassword(newPassword);
		model.setMajortype(majortype);
		model.setClasstype(classtype);
		model.setUser_id(user_id);
		//Instantiate model in controller
		controller.setModel(model);
	
		
		
		//Submit button fields
		if (req.getParameter("changeUsername") != null && newUsername != null) {
			try {
				controller.editUsername();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if (req.getParameter("changePassword") != null && newPassword != null) {
			try {
				controller.editPassword();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (req.getParameter("major") != null && !majortype.equals(null)) {
			try {
				controller.editMajorType();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (req.getParameter("class") != null) {
			try {
				controller.editClassType();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		if(req.getParameter("done") != null) {
			resp.sendRedirect(req.getContextPath() + "/studentHome");
		}
		else {
			req.getRequestDispatcher("/_view/userSettingsStudent.jsp").forward(req, resp);;
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
		
		//Translate parameter to ClassType
		private ClassType getClassTypeFromParameter(String s){
			ClassType classtype = null;
			if(s == null || s.equals("")){
				return null;
			}
			else if (s.equals("FRESHMAN")){
				classtype = ClassType.FRESHMAN;
			}
			else if (s.equals("SOPHOMORE")){
				classtype = ClassType.SOPHOMORE;
			}
			else if (s.equals("JUNIOR")){
				classtype = ClassType.JUNIOR;
			}
			else if (s.equals("SENIOR")){
				classtype = ClassType.SENIOR;
			}
			return classtype;
		}
}
