package com.techchefs.springboot.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@SuppressWarnings("serial")
@Embeddable
public class EmployeeEducationPKBean implements Serializable{

	@JsonIgnore
	@JoinColumn(name = "id")
	@ManyToOne
	private EmployeeInfoBean infoBean;
	@Column(name = "educational_type")
	private String educationalType;
	
}
