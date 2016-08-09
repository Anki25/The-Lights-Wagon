package com.niit.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="Supplier")   //if table name and domain class is name,no need to specify name of table here

public class Supplier {
	@id(name="SUP_ID")
	private String id;      
	@Column(name= "SUP_NAME")
	private String name;
	private String address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
