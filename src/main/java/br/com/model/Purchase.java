package br.com.model;

import java.math.BigDecimal;
import java.util.Date;

public class Purchase {
	
	private Date date;
	private Company company;
	private BigDecimal value;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company= company;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
}
