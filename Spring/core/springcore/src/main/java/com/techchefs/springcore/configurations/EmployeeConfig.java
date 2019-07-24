package com.techchefs.springcore.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.techchefs.springcore.beans.EmployeeInfoBean;

@Configuration
@Import(DeptConfig.class)
public class EmployeeConfig {
	
	@Bean
	public EmployeeInfoBean getEmployeeInfoBean() {
		EmployeeInfoBean bean = new EmployeeInfoBean();
		bean.setName("rakesh");
		
		return bean;
	}
}
