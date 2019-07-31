package com.techchefs.hibernate.code;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.techchefs.hibernate.dto.CustomerBean;
import com.techchefs.hibernate.util.HibernateUtil;

public class DeleteCustomer {
	public static void main( String[] args )
    {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		CustomerBean customerbean = session.get(CustomerBean.class,99);
		Transaction transaction = session.beginTransaction();
		try {
		session.delete(customerbean);
		}
		catch (Exception e) {
			System.out.println("Error Deleting");
		}
		finally {
			transaction.commit();
			session.close();
		}
    }
}
