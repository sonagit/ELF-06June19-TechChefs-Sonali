package com.techchefs.springcore;

import java.util.Scanner;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techchefs.springcore.beans.EmployeeInfoBean;
import com.techchefs.springcore.beans.MessageBean;

public class MessageTest{

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		MessageBean mbean = (MessageBean) ctx.getBean("messageBean");
		System.out.println(mbean.getMessage());

	}
}
