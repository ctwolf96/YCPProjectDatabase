package edu.ycp.cs320.cspath1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("In the Index servlet");
		
		req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (req.getParameter("studentCreation") != null){
			resp.sendRedirect(req.getContextPath() + "/accountCreationStudent");
		}
		else if (req.getParameter("facultyCreation") != null){
			resp.sendRedirect(req.getContextPath() + "/accountCreationFaculty");
		}
		else if (req.getParameter("guestCreation") != null){
			resp.sendRedirect(req.getContextPath() + "/accountCreationGuest");
		}
		else if (req.getParameter("login") != null){
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		else if (req.getParameter("projectSolicitation") != null){
			resp.sendRedirect(req.getContextPath() +"/projectSolicitation");
		}
	}
}
