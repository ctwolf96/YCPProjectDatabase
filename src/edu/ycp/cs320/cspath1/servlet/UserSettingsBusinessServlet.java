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

public class UserSettingsBusinessServlet extends HttpServlet {
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
			req.getRequestDispatcher("/_view/userSettingsBusiness.jsp").forward(req, resp);
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
	
		
		//populate model
		model.setUsername(newUsername);
		model.setPassword(newPassword);
		
		
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
		} 
	
		if(req.getParameter("done") != null) {
			resp.sendRedirect(req.getContextPath() + "/businessHome");
		}
		else {
			req.getRequestDispatcher("/_view/userSettingsBusiness.jsp").forward(req, resp);;
		}
		
		
	}
}
