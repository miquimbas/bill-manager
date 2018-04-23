package br.com.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class Card {
	
	private String ownerName;
	private String number;
	private List<Purchase> purchaseList;
	
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
	public List<Purchase> getPurchaseList() {
		return purchaseList;
	}
	public void setPurchaseList(List<Purchase> purchaseList) {
		this.purchaseList = purchaseList;
	}
}
