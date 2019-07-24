package com.tc.mywebapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tc.mywebapp.bean.EmployeeInfoBean;
import com.tc.mywebapp.dao.EmployeeDao;
import com.tc.mywebapp.dao.EmployeeDAOFactory;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String empId = req.getParameter("empId");
		String password = req.getParameter("password");

		EmployeeDao employeeDAO = EmployeeDAOFactory.getInstance();
		EmployeeInfoBean empBean = employeeDAO.getEmployeeInfo(empId);

		String url = null;
		if (empBean != null && empBean.getPassword().equals(password)) {
			HttpSession session = req.getSession();
			url = "/home.html";
			session.setAttribute("empInfo", empBean);
		} else {
			url = "/login.html";
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
	}
}