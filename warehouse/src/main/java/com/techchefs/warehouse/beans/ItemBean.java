package com.techchefs.warehouse.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class ItemBean implements Serializable {
	
	private static final long serialVersionUID = 2578746478666930415L;
	@Id
	@Column(name = "itemId")
	private int itemId;
	@Column(name = "itemName")
	private String itemName;
	@Column(name = "description")
	private String description;
	@Column(name = "cost")
	private int cost;
	@Column(name = "qty")
	private int qty;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
