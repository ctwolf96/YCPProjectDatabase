package edu.ycp.cs320.cspath1.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.cspath1.controller.UserController;
import edu.ycp.cs320.cspath1.enums.UserType;
import edu.ycp.cs320.cspath1.model.AccountCreationModel;
import edu.ycp.cs320.cspath1.user.User;



public class AccountCreationBusinessServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/accountCreationBusiness.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String errorMessage = null;
		AccountCreationModel model = new AccountCreationModel();
		UserController controller = new UserController();
		
		
		try {
			//Required fields for guest account
			String email = req.getParameter("email");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			model.setEmail(email);
			model.setPassword(password);
			model.setUsername(username);
			model.setUsertype(UserType.BUSINESS);
			controller.setModel(model);
			
			if (username == null || password == null || email == null) {
				errorMessage = "Please specify required fields";
			}
			
			
		} catch (NumberFormatException e) {
			errorMessage = "Invalid double";
		}
		
		
		try {
			User user = controller.createAcct();
			if (user.getUsername() != null) {
				resp.sendRedirect(req.getContextPath() + "/businessHome");
			}
			else {
				req.getRequestDispatcher("/_view/accountCreationBusiness.jsp").forward(req, resp);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Add parameters as request attributes
		req.setAttribute("username", req.getParameter("username"));
		req.setAttribute("password", req.getParameter("password"));
		req.setAttribute("email", req.getParameter("email"));
		
		
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("model", model);
		
		
		// Forward to view to render the result HTML document
		if (req.getParameter("student") != null){
			resp.sendRedirect(req.getContextPath() + "/accountCreationStudent");
		}
		else if (req.getParameter("faculty") != null){
			resp.sendRedirect(req.getContextPath() + "/accountCreationFaculty");
		}
		
	}
	
	

}
