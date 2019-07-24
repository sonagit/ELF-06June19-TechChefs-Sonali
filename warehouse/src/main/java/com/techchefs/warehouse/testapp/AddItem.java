package com.techchefs.warehouse.testapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.techchefs.warehouse.beans.ItemBean;
import com.techchefs.warehouse.config.HibernateConfig;

public class AddItem {
public static void main(String[] args) {
	ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
	SessionFactory factory = context.getBean(SessionFactory.class);
	Session session = factory.openSession();
	
	session.beginTransaction();
	
	ItemBean itemb = new ItemBean();
	
	itemb.setItemId(9);
	itemb.setItemName("xBOX");
	itemb.setDescription("Microsoft xBOX");
	itemb.setCost(20000);
	itemb.setQty(10);
	session.save(itemb);
	
	session.getTransaction().commit();
}
}
