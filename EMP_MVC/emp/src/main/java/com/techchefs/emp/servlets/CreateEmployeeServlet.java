package com.techchefs.emp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techchefs.emp.beans.EmployeeInfoBean;
import com.techchefs.emp.dao.EmployeeDAO;
import com.techchefs.emp.dao.EmployeeDAOFactory;

@WebServlet("/createemployee")
public class CreateEmployeeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EmployeeInfoBean bean = new EmployeeInfoBean();
		try {
			bean.setId(Integer.parseInt(req.getParameter("id")));
			bean.setPassword(req.getParameter("password"));
			bean.setAccountNumber(Long.parseLong(req.getParameter("accountNumber")));
			bean.setName(req.getParameter("name"));
			bean.setEmail(req.getParameter("email"));
			bean.setAge(Integer.parseInt(req.getParameter("age")));
			bean.setDesignation(req.getParameter("designation"));
			bean.setGender(req.getParameter("gender"));
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
			bean.setDob(sdf.parse(req.getParameter("dob")));
			bean.setSalary(Double.valueOf(req.getParameter("salary")));
			bean.setDeptId(Integer.parseInt(req.getParameter("deptid")));
			bean.setPhone(Long.valueOf(req.getParameter("phone")));
			bean.setMngrId(Integer.parseInt(req.getParameter("managerid")));
			bean.setJoiningDate(sdf.parse(req.getParameter("joiningdate")));
		} catch (Exception e) {

		}

		EmployeeDAO dao = EmployeeDAOFactory.getInstance();
		boolean isSave = dao.createEmployeeInfo(bean);

		PrintWriter out = resp.getWriter();

		if (isSave == false) {
			out.println("<HTML>");
			out.println("<BODY>");
			out.println("<H1><span style=\"color: green\"> Employee not saved... </span>");
			out.println("</BODY>");
			out.println("</HTML>");
		} else {
			out.println("<HTML>");
			out.println("<BODY>");
			out.println("<H2><span style=\"color: green\"> Employee saved... </span>");
			out.println("</BODY>");
			out.println("</HTML>");
		}
	}
}
