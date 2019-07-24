package com.techchefs.springcore.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.techchefs.springcore.beans.MessageBean;

@Component
public class MessageConfig {

	@Bean
	@Scope("prototype")
	public MessageBean getMessageBean() {
		MessageBean bean =  new MessageBean();
		bean.setMessage("hello annotation");
		System.out.println("@Component annotation");
		return bean;
	}
}
