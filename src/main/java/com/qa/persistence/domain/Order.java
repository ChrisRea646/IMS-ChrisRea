package com.qa.persistence.domain;

public class Order {
	private int num;
	private double total;
	private int quantity;
	private int cusid;
	private int cardid;
	
	public Order(int num2) {
		this.num = num2;
	}
	

	public Order(int num2, double total2, int quantity2, int cusid2, int cardid2) {
		this.num = num2;
		this.total = total2;
		this.quantity = quantity2;
		
	}
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCusid() {
		return cusid;
	}
	public void setCusid(int cusid) {
		this.cusid = cusid;
	}
	public int getCardid() {
		return cardid;
	}
	public void setCardid(int cardid) {
		this.cardid = cardid;
	}
	public String toString() {
		return "Order Number:" + num  + " | Order quantity:" + quantity+ " | Customer ID:" + cusid+ " | Card ID" + cardid+ " | Order Total: £" + total;
	}
	

}
