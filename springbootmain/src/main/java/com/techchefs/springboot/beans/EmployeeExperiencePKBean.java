package com.techchefs.springboot.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@SuppressWarnings("serial")
@Embeddable
//@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeExperiencePKBean implements Serializable{
	//@XmlTransient
	@JsonIgnore
	@JoinColumn(name = "id")
	@ManyToOne
	private EmployeeInfoBean infoBean;
	
	@Column(name = "company_name")
	private String companyName;
	public EmployeeInfoBean getInfoBean() {
		return infoBean;
	}
	public void setInfoBean(EmployeeInfoBean infoBean) {
		this.infoBean = infoBean;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
