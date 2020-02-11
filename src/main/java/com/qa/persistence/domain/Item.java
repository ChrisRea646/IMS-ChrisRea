package com.qa.persistence.domain;

public class Item {
	
	private int id;
	private String card;
	
	public Item(String card2) {
		this.card = card2;
	}

	public Item(int id2, String card) {
		this.id = id2;
		this.card = card;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String toString() {
		return "id:" + id + "Card:" + card;
	}

}
