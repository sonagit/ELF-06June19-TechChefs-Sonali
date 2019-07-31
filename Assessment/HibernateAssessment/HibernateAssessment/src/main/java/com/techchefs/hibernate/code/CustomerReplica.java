package com.techchefs.hibernate.code;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.techchefs.hibernate.dto.CustomerBean;
import com.techchefs.hibernate.util.HibernateUtil;

public class CustomerReplica {
	public static void main(String[] args) {
	SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.openSession();
	String hql = "insert into CustomerReplicaBean(id,FirstName,LastName, ContactNumber, Address, City, State, Country) "
			+ "select id,FirstName,LastName, ContactNumber, Address, City, State, Country from CustomerBean";

	Transaction transaction = null;
	try
	{
		transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		int result = query.executeUpdate();
		System.out.println("result:" + result);
		transaction.commit();
	}catch(
	Exception e)
	{
		transaction.rollback();
		e.printStackTrace();
	}finally
	{
		session.close();
	}
}}
