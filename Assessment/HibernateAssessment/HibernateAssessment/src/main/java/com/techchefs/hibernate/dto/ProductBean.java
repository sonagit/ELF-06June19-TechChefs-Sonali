package com.techchefs.hibernate.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Product")
public class ProductBean implements Serializable {
	
	@Id
	@Column(name ="ProductId")
	private int ProductId;
	@Column(name ="ProductName")
	private String ProductName;
	@Column(name ="Price")
	private double Price;
	@Column(name ="Color")
	private String color;
	@Column(name ="Weight")
	private double weight;
	
}
