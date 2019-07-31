package com.techchefs.hibernate.code;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.techchefs.hibernate.dto.CustomerBean;
import com.techchefs.hibernate.util.HibernateUtil;

public class StudentData {
	public static void main(String[] args) {
	SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.openSession();
	String minhql = "select min(sb.TotalMarks) from StudentBean sb";
	String maxhql = "select max(sb.TotalMarks) from StudentBean sb";
	String avghql = "select avg(sb.TotalMarks) from StudentBean sb";

	Transaction transaction = null;
	try
	{
		transaction = session.beginTransaction();
		Query minquery = session.createQuery(minhql);
		List resultmin = minquery.list();
		System.out.println("Minimum result:" + resultmin);
		
		Query maxquery = session.createQuery(maxhql);
		List resultmax = maxquery.list();
		System.out.println("Maximum result:" + resultmax);
		
		Query avgquery = session.createQuery(avghql);
		List resultavg = avgquery.list();
		System.out.println("Average result:" + resultavg);
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
