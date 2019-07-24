package com.techchefs.warehouse.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class HibernateConfig {
	@Bean
	public static SessionFactory getSessionFactory() {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		return factory;		
	}
}
