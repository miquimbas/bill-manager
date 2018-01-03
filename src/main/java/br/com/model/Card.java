package br.com.model;

import java.util.List;

public class Card {
	
	private String ownerName;
	private String number;
	private List<Shopping> shoppingList;
	
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public List<Shopping> getShoppingList() {
		return shoppingList;
	}
	public void setShoppingList(List<Shopping> shoppingList) {
		this.shoppingList = shoppingList;
	}
}
