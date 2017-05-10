package edu.ycp.cs320.cspath1.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.enums.UserType;
import edu.ycp.cs320.cspath1.user.User;
import edu.ycp.cs320.cspath1.controller.SearchUsers;

public class UserSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SearchUsers search = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		if (user == null)
		{
			resp.sendRedirect(req.getContextPath()+"/login");
			return;
		} 
		
		req.getRequestDispatcher("/_view/userSearch.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			User user = (User) req.getSession().getAttribute("user");
		
		 	if (req.getParameter("logout") != null) {
				req.getSession().invalidate();
				resp.sendRedirect(req.getContextPath() + "/login");
			} else if (req.getParameter("userSearch") != null) {
				resp.sendRedirect(req.getContextPath() + "/userSearch");
			} else if (req.getParameter("proposalSearch") != null) {
				resp.sendRedirect(req.getContextPath() + "/proposalSearch");
			} else if (req.getParameter("solicitationSearch") != null) {
				resp.sendRedirect(req.getContextPath() + "/solicitationSearch");
			} else if (req.getParameter("solicitation") != null) {
				resp.sendRedirect(req.getContextPath() + "/projectSolicitation");
			} else if (req.getParameter("proposal") != null) {
				resp.sendRedirect(req.getContextPath() + "/projectProposal");
			} else if (req.getParameter("myProjects") != null) {
				resp.sendRedirect(req.getContextPath() + "/myProjects");
			} else if (req.getParameter("settings") != null) {
				resp.sendRedirect(req.getContextPath() + "/userSettingsStudent");
			} else if (req.getParameter("home") != null && user.getUsertype().equals(UserType.STUDENT)) {
				resp.sendRedirect(req.getContextPath() + "/studentHome");
			} else if (req.getParameter("home") != null && user.getUsertype().equals(UserType.FACULTY)) {
				resp.sendRedirect(req.getContextPath() + "/facultyHome");
			} else if (req.getParameter("home") != null && user.getUsertype().equals(UserType.BUSINESS)) {
				resp.sendRedirect(req.getContextPath() + "/businessHome");
			}
		
//		User user				 	=null;
		ArrayList<User> users		=null;
		String searchField 			=null;
		String errorMessage			=null;
		String username				=null;
		String email				=null;
		String firstname			=null;
		String lastname				=null;
		MajorType majorType			=null;
		ClassType classType         =null;
		UserType usertype			=null;
		String name = null;
		String number = null;
		String address = null;
		
		searchField = req.getParameter("attribute");
		majorType = getMajorTypeFromParameter(req.getParameter("keyword"));
		usertype = getUserTypeFromParameter(req.getParameter("keyword"));
		
		search = new SearchUsers();
		users = new ArrayList<User>();
		
		/*System.out.println(searchField);
		System.out.println("keyword");*/
		if(searchField.equals("username")){
			try {
				username = req.getParameter("keyword");
				//System.out.println("not null");
				users.add(search.getUserByUsername(username));
				//System.out.println(users.size());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(searchField.equals("email")){
			try {
				email = req.getParameter("keyword");
				users.add(search.getUserByEmail(email));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(searchField.equals("firstname")){
			try {
				firstname = req.getParameter("keyword");
				users.addAll(search.getUserByName(firstname, null));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(searchField.equals("lastname")){
			try {
				lastname = req.getParameter("keyword");
				users.addAll(search.getUserByName(null, lastname));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(searchField.equals("majortype")){
			try {
				users.addAll(search.getUsersByMajor(majorType));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(searchField.equals("usertype")){
			try {
				users.addAll(search.getUsersByUserType(usertype));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if (users == null) {
			errorMessage = "User/Users not found in library";
		}
		else {
			user  = users.get(0);
		}
		req.setAttribute("users", users);
		req.setAttribute("user", user);
		req.setAttribute("errorMessage", errorMessage);
		
		req.getRequestDispatcher("/_view/userSearch.jsp").forward(req, resp);
	}
	
	private MajorType getMajorTypeFromParameter(String s){
		MajorType majortype = null;
		if (s == null || s.equals("")){
			return null;
		}
		else if (s.equals("ME")||s.equals("Mechanical")){
			majortype = MajorType.ME;
			
		}
		else if (s.equals("CE")||s.equals("Computer")){
			majortype = MajorType.CE;
		}
		else if(s.equals("CS")||s.equals("Computer Science")){
			majortype = MajorType.CS;
		}
		else if(s.equals("EE")||s.equals("Electrical")){
			majortype = MajorType.EE;
		}
		return majortype;
	}
	
	private UserType getUserTypeFromParameter(String s){
		UserType usertype = null;
		if (s == null || s.equals("")){
			return null;
		}
		else if (s.equals("student")||s.equals("Student")){
			usertype = UserType.STUDENT;
			
		}
		else if (s.equals("faculty")||s.equals("Faculty")){
			usertype = UserType.FACULTY;
		}
		else if(s.equals("business")||s.equals("Business")){
			usertype = UserType.BUSINESS;
		}
		else if(s.equals("admin")||s.equals("Admin")){
			usertype = UserType.ADMIN;
		}
		return usertype;
	}
}
