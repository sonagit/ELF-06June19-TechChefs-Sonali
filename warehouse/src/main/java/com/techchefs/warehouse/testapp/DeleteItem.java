package com.techchefs.warehouse.testapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.techchefs.warehouse.beans.ItemBean;
import com.techchefs.warehouse.config.HibernateConfig;

public class DeleteItem {
public static void main(String[] args) {
	ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
	SessionFactory factory = context.getBean(SessionFactory.class);
	Session session = factory.openSession();
	
	session.beginTransaction();
	
	ItemBean itemb = session.get(ItemBean.class, 9);
	session.delete(itemb);
	session.getTransaction().commit();

	session.close();
}
}
