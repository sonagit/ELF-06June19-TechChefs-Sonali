package com.techchefs.emp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginPageServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession(false);
		if(session == null) {
			out.println("<h1> <span style='color:red'> INVALID SESSION!!!! Please Login Again");
			out.println("<BR><BR>");
		}else {
			
		}
		//RequestDispatcher dispatcher = req.getRequestDispatcher();
		//dispatcher.forward(req, resp);
	}

}
