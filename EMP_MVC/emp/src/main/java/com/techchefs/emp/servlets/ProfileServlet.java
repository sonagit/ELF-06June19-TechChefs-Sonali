package com.techchefs.emp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techchefs.emp.beans.EmployeeInfoBean;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		EmployeeInfoBean bean = (EmployeeInfoBean) session.getAttribute("empInfo");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<HTML>");
		out.println("<BODY>");
		out.println("<H2><span style=\"color: green\"> Employee Profile... </span>");
		out.println("<BR>");
		out.println("<BR> ID : " + bean.getId());
		out.println("<BR> name : " + bean.getName());
		out.println("<BR> age : " + bean.getAge());
		out.println("<BR> email : " + bean.getEmail());
		out.println("<BR> gender : " + bean.getGender());
		out.println("<BR> designation : " + bean.getDesignation());
		out.println("<BR> account no : " + bean.getAccountNumber());
		out.println("</BODY>");
		out.println("</HTML>");
	}
}
