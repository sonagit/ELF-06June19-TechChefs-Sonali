package com.techchefs.springcore.annotationtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.techchefs.springcore.beans.DepartmentBean;
import com.techchefs.springcore.beans.EmployeeInfoBean;
import com.techchefs.springcore.configurations.EmployeeConfig;

public class EmployeeTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		
		EmployeeInfoBean bean = ctx.getBean(EmployeeInfoBean.class);
		
		DepartmentBean deptBean = bean.getDeptBean();
	}

}
