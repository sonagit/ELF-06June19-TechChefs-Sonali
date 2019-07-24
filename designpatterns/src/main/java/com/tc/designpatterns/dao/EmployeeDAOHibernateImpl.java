package com.tc.designpatterns.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tc.designpatterns.beans.EmployeeInfoBean;

import lombok.extern.java.Log;

@Log
public final class EmployeeDAOHibernateImpl implements EmployeeDao {

	public ArrayList<EmployeeInfoBean> getAllEmployeeInfo() {
		// TO DO
		return null;

	}

	public EmployeeInfoBean getEmployeeInfo(String id) {
		try {
			return getEmployeeInfo(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		}

	}

	public EmployeeInfoBean getEmployeeInfo(int id) {
		try {
			// 1. Load the config file
			Configuration cfg = new Configuration();
			cfg.configure();// By default it looks for hibernate.cfg.xml file
//			cfg.configure(new File("D:\\MyHibernateConfigFile.xml"));

//			cfg.configure(new URL(
//					"https://raw.githubusercontent.com/abhishekmahajan0312/ELF-06June19-techchefs-abhishek/master/MyHibernateConfigFile.xml"));
//
			cfg.addAnnotatedClass(EmployeeInfoBean.class);

			// 2. Build the Session Factory
			SessionFactory factory = cfg.buildSessionFactory();

			// 3. Open Session
			Session session = factory.openSession();

			// 4. Interact with the DB via Session
			EmployeeInfoBean bean = session.get(EmployeeInfoBean.class, id);

			// 5. Close Session
			session.close();

			return bean;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean createEmployeeInfo(EmployeeInfoBean bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployeeInfo(EmployeeInfoBean bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployeeInfo(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployeeInfo(String id) {
		// TODO Auto-generated method stub
		return false;
	}

//END of getEmployeeInfo(int) method

}
