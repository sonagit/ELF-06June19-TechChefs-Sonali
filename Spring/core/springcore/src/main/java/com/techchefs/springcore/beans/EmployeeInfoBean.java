package com.techchefs.springcore.beans;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EmployeeInfoBean {
	
	private String name;
	
	@Autowired
	@Qualifier("rr")
	private DepartmentBean deptBean;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DepartmentBean getDeptBean() {
		return deptBean;
	}

	public void setDeptBean(DepartmentBean deptBean) {
		this.deptBean = deptBean;
	}

	@PreDestroy
	public void destroy(){
		System.out.println("destroy");
	}
	
}
