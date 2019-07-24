package com.techchefs.springcore;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techchefs.springcore.beans.EmployeeInfoBean;
import com.techchefs.springcore.beans.MessageBean;

public class MessageTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		Scanner sc = new Scanner(System.in);

		MessageBean mbean = (MessageBean) ctx.getBean("messageBean");
		System.out.println(mbean.getMessage());

		EmployeeInfoBean eBean = (EmployeeInfoBean) ctx.getBean("empInfoBean");
		System.out.println(eBean.getName());
		
		System.out.println(eBean.getDeptBean().getDeptId());
	}
}
