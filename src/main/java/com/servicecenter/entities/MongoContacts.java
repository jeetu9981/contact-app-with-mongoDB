package com.servicecenter.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="contacts")
public class MongoContacts {
	private String name;
	private String number;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
