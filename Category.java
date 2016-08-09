package com.niit.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Category")   //if table name and domain class is name,no need to specify name of table here
public class Category {
	
	@id(name="CAT_ID")
	private String id;      //@Transient can be used before a var to create a temp data and store in db
	@Column(name= "CAT_NAME")
	private String name;
	private String description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
