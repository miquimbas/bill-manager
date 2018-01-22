package br.com.model;

import java.util.ArrayList;
import java.util.List;

public class Santander implements Bank{

	@Override
	public Bill buildBill(List<String> desnormalizedBillRows) {
		List<String> headerPatterns = getHeaderPatterns();
		
		for (String row : desnormalizedBillRows) {
			if (!isShopRow(row)) continue;
			
			
		}

		return null;
	}

	private boolean isShopRow(String row) {
		if (row == null || row.isEmpty()) return false;
		
		
		
		return false;
	}

	private ArrayList<String> getHeaderPatterns() {
		ArrayList<String> headerPatterns = new ArrayList<>();
		headerPatterns.add("Data");
		headerPatterns.add("Descrição");
		headerPatterns.add("Valor (US$)");
		headerPatterns.add("Valor (R$)");
		return headerPatterns;
	}
}
