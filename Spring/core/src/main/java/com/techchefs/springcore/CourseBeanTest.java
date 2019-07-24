package com.techchefs.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techchefs.springcore.beans.CourseBean;

public class CourseBeanTest{

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		CourseBean cbean = (CourseBean) ctx.getBean("courseBean");
		System.out.println(cbean.getCourseId());
		System.out.println(cbean.getCourseName());
		System.out.println(cbean.getFacultyName());

	}
}
