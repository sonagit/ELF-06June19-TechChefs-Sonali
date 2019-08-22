package com.techchefs.springboot.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@SuppressWarnings("serial")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userEmailId")
@JsonRootName(value = "user")
@Entity
@Table(name = "user")
public class UserBean implements Serializable {
	@Id
	@Column(name = "user_id")
	private String userEmailId;
	@Column(name = "user_fname")
	private String UserFName;
	@Column(name = "user_lname")
	private String UserLName;
	@Column(name = "age")
	private Integer age;
	@Column(name = "gender")
	private String gender;
	@Column(name = "phone")
	private long phone;
	@Column(name = "joining_date")
	private Date joiningDate;
	@Column(name = "ban_status",nullable = false)
	private Boolean banStatus;
	
	@Column(name="password", nullable = false)
	private String password;
	@Column(name="role_id", nullable = false)
	private Integer roleId;
	
}
