package com.techchefs.springboot.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="book")
public class BookBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer book_id;
	@Column(name="book_title")
	private String bookTitle;
	@Column(name="author")
	private String author;
	@Column(name="publication")
	private String publication;
	@Column(name="countcopies")
	private Integer countcopies;
	@Column(name="price")
	private Integer price;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id", referencedColumnName = "category_id" )
	private CategoryBean categoryId;
	
}
