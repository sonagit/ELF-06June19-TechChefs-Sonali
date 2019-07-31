package com.techchefs.hibernate.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Student")
public class StudentBean implements Serializable {
	
	@Id
	@Column(name ="RollNum")
	private int RollNum;
	@Column(name ="FirstName")
	private String FirstName;
	@Column(name ="LastName")
	private String LastName;
	@Column(name ="Subject")
	private String Subject;
	@Column(name ="TotalMarks")
	private double TotalMarks;
	
}
