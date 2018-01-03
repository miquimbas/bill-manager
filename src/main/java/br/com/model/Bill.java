package br.com.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Bill {
	
	private Date dueDate;
	private BigDecimal value;
	private List<Card> cards;
	
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public BigDecimal getValor() {
		return value;
	}
	public void setValor(BigDecimal value) {
		this.value = value;
	}
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
}
