package br.com.model;

import java.util.List;

public interface Bank {

	public Bill buildBill(List<String> lines);
}
