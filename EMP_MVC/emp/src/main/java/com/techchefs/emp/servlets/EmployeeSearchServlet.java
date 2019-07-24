package com.techchefs.emp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techchefs.emp.beans.EmployeeInfoBean;
import com.techchefs.emp.dao.EmployeeDAO;
import com.techchefs.emp.dao.EmployeeDAOFactory;

@WebServlet(urlPatterns = "/search", initParams = { @WebInitParam(name = "actress", value = "basanti") })
public class EmployeeSearchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idValue = req.getParameter("empId");

		String record = req.getParameter("record");

		EmployeeDAO dao = EmployeeDAOFactory.getInstance();
		List<EmployeeInfoBean> beans = dao.getEmployeesInfo(idValue, record);

		PrintWriter out = resp.getWriter();

		if (beans == null) {
			out.println("<HTML>");
			out.println("<BODY>");
			out.println("<H1><span style=\"color: green\"> Employees not Found... </span>");
			out.println("</BODY>");
			out.println("</HTML>");
		}

		for (EmployeeInfoBean bean : beans) {

			out.println("<HTML>");
			out.println("<BODY>");
			out.println("<BR>");
			out.println("<BR> <a href = '/emp/search?empId=" + bean.getId() + "&record=1'>" + bean.getId() + "</a>");
			if (record != null) {
				out.println("<TABLE><tr><BR> name : " + bean.getName() + "</tr>");
				out.println("<BR><tr> age : " + bean.getAge()+ "</tr>");
				out.println("<BR><tr> email : " + bean.getEmail()+ "</tr>");
				out.println("<BR><tr> gender : " + bean.getGender()+ "</tr>");
				out.println("<BR><tr> designation : " + bean.getDesignation()+ "</tr>");
				out.println("<BR><tr> account no : " + bean.getAccountNumber()+ "</tr> </TABLE>");
			}
			out.println("</BODY>");
			out.println("</HTML>");

		}
	}
}
