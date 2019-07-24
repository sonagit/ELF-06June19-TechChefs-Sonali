package com.techchefs.springcore.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MessageBean implements ApplicationContextAware {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.out.println("inside setApplicationContext App ApplicationContextAware");
		
	}
	public void setBeanName(String name) {
		System.out.println("Bean name" + name);
	}
	
}
