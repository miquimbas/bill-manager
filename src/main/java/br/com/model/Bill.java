package br.com.model;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Bill {
	
	private Date dueDate;
	private BigDecimal totalValue;
	private List<Card> cards;
	
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public BigDecimal getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(BigDecimal value) {
		this.totalValue = value;
	}
	
	
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	@Override
	public String toString() {
		String output = "";
		for (Card card : cards) {
			output += "Titular: " + card.getOwnerName() + ", Número: " + card.getNumber() + "\n";
			output += "Lista de compras: \n";
			
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			
			for (Purchase purchase : card.getPurchaseList()) {
				output += purchase.getDate() + " | " + purchase.getCompany().getName() + " | " + purchase.getValue() + "\n";
			}
			
			output += "----------------------------------";
		}
		
		return output;
	}
}
