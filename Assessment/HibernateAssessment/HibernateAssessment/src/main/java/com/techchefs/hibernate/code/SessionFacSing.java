package com.techchefs.hibernate.code;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.techchefs.hibernate.util.HibernateUtil;

public class SessionFacSing {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		System.out.println("session is singleton");
	}

}
