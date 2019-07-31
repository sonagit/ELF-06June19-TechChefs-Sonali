package com.techchefs.hibernate.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Customer")
public class CustomerBean implements Serializable {
	
	@Id
	@Column(name ="Id")
	private int id;
	@Column(name ="FirstName")
	private String FirstName;
	@Column(name ="LastName")
	private String LastName;
	@Column(name ="ContactNumber")
	private long ContactNumber;
	@Column(name ="Address")
	private String Address;
	@Column(name ="City")
	private String City;
	@Column(name ="State")
	private String State;
	@Column(name ="Country")
	private String Country;
	
}
