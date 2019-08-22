package com.techchefs.springboot.beans;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="bookSKU")
public class BookSKUBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer bookSKU_id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id", referencedColumnName = "book_id" )
	private BookBean book_id;
	
	@Column(name="total_count")
	private Integer totalCount;
	
	@Column(name="issued_count")
	private Integer issuedCount;
	
	@Column(name="remain_count")
	private Integer remainCount;
	
	@Column(name="status_id")
	private Integer statusId;
}
