package edu.ycp.cs320.cspath1.servlet.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import edu.ycp.cs320.cspath1.model.Numbers;

public class MultiplyNumbersAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doRequest(req, resp);
	}

	private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get parameters
		Numbers model = new Numbers();
		Double first = model.getFirst();
		Double second = model.getSecond();
		Double third = model.getThird();
		// Check whether parameters are valid
		if (first == null || second == null || third == null) {
			badRequest("Bad parameters", resp);
			return;
		}
		
		// Use a controller to process the request
		
		
		
		// Send back a response
		resp.setContentType("text/plain");
		resp.getWriter().println(
				"{ \"first\": " + model.getFirst() + 
				", \"second\": " + model.getSecond() +
				", \"third\": " + model.getThird() +
				", \"result\": " + model.getResult() + "}" );
	

	}

	

	private void badRequest(String message, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		resp.getWriter().println(message);
	}
}
