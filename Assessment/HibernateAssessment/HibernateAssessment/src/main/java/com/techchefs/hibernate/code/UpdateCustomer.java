package com.techchefs.hibernate.code;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.techchefs.hibernate.dto.CustomerBean;
import com.techchefs.hibernate.util.HibernateUtil;

public class UpdateCustomer {
	public static void main( String[] args )
    {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		CustomerBean customerbean = new CustomerBean();
		customerbean.setId(99);
		customerbean.setFirstName("AddExample");
		customerbean.setLastName("AddExample");
		customerbean.setContactNumber(786786123);
		customerbean.setAddress("AddExampleAddress");
		customerbean.setCity("AddCity");
		customerbean.setState("AddState");
		customerbean.setCountry("AddCountry");
	
		Transaction transaction = session.beginTransaction();
		session.update(customerbean);
		transaction.commit();

		session.close();
		
    }
}
