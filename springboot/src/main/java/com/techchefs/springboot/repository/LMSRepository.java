package com.techchefs.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.techchefs.springboot.beans.UserBean;


public interface LMSRepository extends CrudRepository<UserBean, String>{
	
	}
