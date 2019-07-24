package com.techchefs.springcore.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.techchefs.springcore.beans.DepartmentBean;

@Component
public class DeptConfig {

	@Bean(name="rr")
	public DepartmentBean getDepartmentBean() {
		DepartmentBean bean = new DepartmentBean();
		bean.setDeptId(1);
		bean.setDeptName("RR");

		return bean;
	}

}
