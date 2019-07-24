package com.techchefs.emp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techchefs.emp.beans.EmployeeInfoBean;
import com.techchefs.emp.dao.EmployeeDAO;
import com.techchefs.emp.dao.EmployeeDAOFactory;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String empId = req.getParameter("empId");
		String password = req.getParameter("password");

		EmployeeDAO employeeDAO = EmployeeDAOFactory.getInstance();
		EmployeeInfoBean empBean = employeeDAO.getEmployeeInfo(empId);
		PrintWriter out = resp.getWriter();

		String url = null;
		if (empBean != null && empBean.getPassword().equals(password)) {
			HttpSession session = req.getSession();
			url = "/home.html";
				
		} else {
			url = "/loginFail.jsp?errorMsg=Invalid Name/PWD";
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
	}
}
