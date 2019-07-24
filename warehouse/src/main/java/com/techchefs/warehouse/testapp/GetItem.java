package com.techchefs.warehouse.testapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.techchefs.warehouse.beans.ItemBean;
import com.techchefs.warehouse.config.HibernateConfig;

public class GetItem {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
		SessionFactory factory = context.getBean(SessionFactory.class);
		Session session = factory.openSession();
		
		ItemBean itemb = new ItemBean();
		
		System.out.println("Item ID" + itemb.getItemId());
		System.out.println("Item Name" + itemb.getItemName());
		System.out.println("Item Description" + itemb.getDescription());
		System.out.println("Item Cost" + itemb.getCost());
		System.out.println("Item Qty" + itemb.getQty());
	}		
				
				
		
}
