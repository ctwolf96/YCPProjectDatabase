package edu.ycp.cs320.cspath1.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.cspath1.controller.UserController;
import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.enums.UserType;
import edu.ycp.cs320.cspath1.model.AccountCreationModel;
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
		String errorMessage = null;
		AccountCreationModel model = new AccountCreationModel();
		UserController controller = new UserController();
		
	
			//All required fields for faculty account
		String email = req.getParameter("email");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		MajorType majortype = getMajorTypeFromParameter(req.getParameter("majortype"));
			
		model.setEmail(email);
		model.setPassword(password);
		model.setUsername(username);
		model.setMajortype(majortype);
		model.setUsertype(UserType.FACULTY);
		controller.setModel(model);
		
			
			
		if (username == null || password == null || email == null) {
			errorMessage = "Please specify required fields";
		}
		
		
		// Add parameters as request attributes
		req.setAttribute("username", req.getParameter("username"));
		req.setAttribute("password", req.getParameter("password"));
		req.setAttribute("email", req.getParameter("email"));
		req.setAttribute("majortype", req.getParameter("majortype"));
		
		
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("model", model);
		
		try {
			User user = controller.createAcct();
			if (user.getUsername() != null) {
				resp.sendRedirect(req.getContextPath() + "/facultyHome");
			}
			else {
				req.getRequestDispatcher("/_view/accountCreationFaculty.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Forward to view to render the result HTML document
		if (req.getParameter("guest") != null){
			resp.sendRedirect(req.getContextPath() + "/accountCreationBusiness");
		}
		else if (req.getParameter("student") != null){
			resp.sendRedirect(req.getContextPath() + "/accountCreationStudent");
		}
		else {
			resp.sendRedirect(req.getContextPath() + "/facultyHome");
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