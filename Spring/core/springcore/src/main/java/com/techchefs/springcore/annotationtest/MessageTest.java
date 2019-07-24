package com.techchefs.springcore.annotationtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.techchefs.springcore.beans.MessageBean;
import com.techchefs.springcore.configurations.MessageConfig;

public class MessageTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MessageConfig.class);
		
		((ConfigurableApplicationContext)ctx).registerShutdownHook();
		
		MessageBean bean1 = ctx.getBean(MessageBean.class);
		
		MessageBean bean2 = ctx.getBean(MessageBean.class);
		bean2.setMessage("annotation in spring!!!");
		
		System.out.println(bean1.getMessage());
		System.out.println(bean2.getMessage());

	}

}
