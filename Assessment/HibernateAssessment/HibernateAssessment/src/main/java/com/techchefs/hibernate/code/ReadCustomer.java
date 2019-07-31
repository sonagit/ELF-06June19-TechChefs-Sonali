package com.techchefs.hibernate.code;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.techchefs.hibernate.dto.CustomerBean;
import com.techchefs.hibernate.util.HibernateUtil;

public class ReadCustomer {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		CustomerBean customerbean = new CustomerBean();
		customerbean = session.find(CustomerBean.class,1);
		
		System.out.println("Customer Id -> " + customerbean.getId());
		System.out.println("Customer firstName ->" + customerbean.getFirstName());
		System.out.println("Customer Last Name ->" + customerbean.getLastName());
		System.out.println("Customer Contact Number ->" + customerbean.getContactNumber());
		System.out.println("Customer Address -->" + customerbean.getAddress());
		System.out.println("Customer City -->" + customerbean.getCity());
		System.out.println("Customer State -->" + customerbean.getState());
	    System.out.println("Customer Country -->" + customerbean.getCountry());
	
		session.close();
	}

}
