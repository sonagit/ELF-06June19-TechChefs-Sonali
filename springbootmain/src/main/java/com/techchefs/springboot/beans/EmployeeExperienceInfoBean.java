package com.techchefs.springboot.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_experienceinfo")
public class EmployeeExperienceInfoBean implements Serializable {
	
	@EmbeddedId
	private EmployeeExperiencePKBean experiencePKBean;
	public EmployeeExperiencePKBean getExperiencePKBean() {
		return experiencePKBean;
	}
	public void setExperiencePKBean(EmployeeExperiencePKBean experiencePKBean) {
		this.experiencePKBean = experiencePKBean;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Date getReleavingDate() {
		return releavingDate;
	}
	public void setReleavingDate(Date releavingDate) {
		this.releavingDate = releavingDate;
	}
	@Column(name = "designation")
	private String designation;
	@Column(name = "joining_date")
	private Date joiningDate ;
	@Column(name = "releaving_date")
	private Date releavingDate;
	
	
}
