package com.qa.persistence.domain;

public class Item {
	
	private int id;
	private String card;
	private double cardCost;
	
	public double getCardCost() {
		return cardCost;
	}

	public void setCardCost(double cardCost) {
		this.cardCost = cardCost;
	}
 
	public Item(String card2) {
		this.card = card2;
	}

	public Item(int id2, String card, double cardCost2) {
		this.id = id2;
		this.card = card;
		this.cardCost = cardCost2;
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
		return "id:" + id + " | Card:" + card + " | Card_Cost:£" + cardCost;
	}

}
