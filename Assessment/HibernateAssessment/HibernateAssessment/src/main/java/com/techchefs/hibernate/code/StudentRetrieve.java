package com.techchefs.hibernate.code;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.techchefs.hibernate.dto.StudentBean;
import com.techchefs.hibernate.util.HibernateUtil;

public class StudentRetrieve {
	public static void main(String[] args) {
	SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.openSession();
	StudentBean studentbean = new StudentBean();
	studentbean = session.find(StudentBean.class,1);

	Transaction transaction = null;
	try
	{
		System.out.println("Student Id -> " + studentbean.getRollNum());
		System.out.println("Student firstName ->" + studentbean.getFirstName());
		System.out.println("Student Last Name ->" + studentbean.getLastName());
		System.out.println("Student Subject->" + studentbean.getSubject());
		System.out.println("Student Total Marks -->" + studentbean.getTotalMarks());
		
		session.close();
		
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
