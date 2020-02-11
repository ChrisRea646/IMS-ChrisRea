package com.qa.persistence.domain;

public class Customer{

	private int id;
	private String name;
	
	public Customer(String name2) {
		this.name = name2;
	}

	public Customer(int id2, String name) {
		this.id = id2;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getname() {
		return name;
	}

	public void name(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "id:" + id + "Name:" + name;
	}



}
