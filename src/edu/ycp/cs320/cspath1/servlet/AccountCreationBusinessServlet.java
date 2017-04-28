package edu.ycp.cs320.cspath1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.cspath1.enums.UserType;
import edu.ycp.cs320.cspath1.user.Business;



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
		Business business = new Business();
		
		String email = req.getParameter("email");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String password1 = req.getParameter("password1");
		String businessName = req.getParameter("businessName");
		String address = req.getParameter("address");
		String phoneNumber = req.getParameter("phoneNumber");
			
		business.setEmail(email);
		business.setPassword(password);
		business.setUsername(username);
		business.setUsertype(UserType.BUSINESS);
		business.setAddress(address);
		business.setName(businessName);
		business.setNumber(phoneNumber);
			
		if (username == null || password == null || password1 == null || email == null || address == null || phoneNumber == null || businessName == null) {
			errorMessage = "Please specify required fields";
		} else if (password != password1) {
			errorMessage = "Passwords do not match";
		}
		
		// Add parameters as request attributes
		req.setAttribute("username", req.getParameter("username"));
		req.setAttribute("password", req.getParameter("password"));
		req.setAttribute("email", req.getParameter("email"));
		req.setAttribute("password1", req.getParameter("password1"));
		req.setAttribute("address", req.getParameter("address"));
		req.setAttribute("phoneNumber", req.getParameter("phoneNumber"));
		req.setAttribute("businessName", req.getParameter("businessName"));
		
		
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		
		
		// Forward to view to render the result HTML document
		if (req.getParameter("student") != null){
			resp.sendRedirect(req.getContextPath() + "/accountCreationStudent");
		}
		else if (req.getParameter("faculty") != null){
			resp.sendRedirect(req.getContextPath() + "/accountCreationFaculty");
		}
		else if (req.getParameter("submit") != null) {
			resp.sendRedirect(req.getContextPath() + "/businessHome");
		} else {
			req.getRequestDispatcher("/_view/accountCreationBusiness.jsp").forward(req, resp);
		}
	}
	
	

}
