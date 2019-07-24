package com.techchefs.warehouse.testapp;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techchefs.warehouse.beans.ItemBean;
import com.techchefs.warehouse.util.HibernateUtil;

public class AddTest {
	public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	Session session = ((SessionFactory) context.getBean("hibernateutil", HibernateUtil.class)).openSession();
	
	
	ItemBean itemb = new ItemBean();
	itemb.setItemId(9);
	itemb.setItemName("xBOX");
	itemb.setDescription("Microsoft xBOX");
	itemb.setCost(20000);
	itemb.setQty(10);
	session.save(itemb);
	
	Transaction txn = null;
	try{
		txn = (Transaction) session.beginTransaction();
		session.saveOrUpdate(itemb);
		txn.commit();
	}catch(Exception e) {
		System.out.println("Error");
	}
}
}
