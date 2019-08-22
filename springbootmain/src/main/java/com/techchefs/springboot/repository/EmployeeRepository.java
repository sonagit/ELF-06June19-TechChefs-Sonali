package com.techchefs.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.techchefs.springboot.beans.EmployeeInfoBean;
import com.techchefs.springboot.beans.EmployeeOtherInfoBean;


public interface EmployeeRepository extends JpaRepository<EmployeeInfoBean, Integer>{
	
	@Query("select e from EmployeeOtherInfoBean e where e.infoBean=:id")
	public EmployeeOtherInfoBean findByEmpById (@Param("id") EmployeeInfoBean bean);
}
