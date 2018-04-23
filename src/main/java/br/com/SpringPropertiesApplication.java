package br.com;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import br.com.model.Bank;
import br.com.model.Bill;
import br.com.model.Card;
import br.com.model.Company;
import br.com.model.Purchase;
import br.com.service.FileService;

@SpringBootApplication
public class SpringPropertiesApplication extends SpringBootServletInitializer {

	private static final String FILE_PATH = "C:\\Users\\Mica\\Downloads\\faturas\\comprovante6B210B26D52533668E90EC19.pdf";

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringPropertiesApplication.class, args);
		
		List<String> lines = new FileService().getLinesFromPdf(new File(FILE_PATH));
//		Bill bill = buildBill(new Santander(), lines);
//		saveBill(bill);

		Bill bill = new Bill();
		Card card = null;
		
		for (String line : lines) {
			if (isCardLine(line)) {
				if (card != null) {
					if (bill.getCards() == null) {
						bill.setCards(new ArrayList<Card>());
					}
						
					bill.getCards().add(card);
				}
				
				card = new Card();
				card.setOwnerName(getOwnerName(line));
				card.setNumber(getNumber(line));
			}
			
			if (isPurchaseLine(line)) {
				if (card == null) {
					continue;
				}
				
				Purchase purchase = new Purchase ();
				purchase.setDate(getDate(line));
				purchase.setValue(getValue(line));
				purchase.setCompany(getCompany(line));
				
				if (card.getPurchaseList() == null) {
					card.setPurchaseList(new ArrayList<Purchase>());
				}
				
				card.getPurchaseList().add(purchase);
			}
		}
		
		System.out.println(bill.toString());
	}

	private static boolean isCardLine(String line) {
		return line.contains("NªCartao") && line.contains("Final:") && line.contains("Titular");
	}

	private static String getNumber(String line) {
		return line.substring(line.indexOf("Final") + 6, line.indexOf("Final") + 11);
	}

	private static String getOwnerName(String line) {
		return line.substring(line.indexOf("Titular") + 8, line.length());
	}

	private static Company getCompany(String line) {
		Company company = new Company();
		company.setName(line.substring(11, line.indexOf("US$")-1));
		return company;
	}

	private static BigDecimal getValue(String linha) {
		String value = linha.substring(linha.indexOf("R$") + 3);
		try {
			if (value.length() > 6) {
				value = value.replace(".", "");
			}
			
			return new BigDecimal (value.replace(",", "."));
		}catch (NumberFormatException e) {
			System.out.println("Erro na conversão para bigdecimal, valor: " + value);
		}
		return null;
	}

	private static Date getDate(String linha) {
		Integer day = new Integer(linha.substring(0,2));
		Integer month = new Integer(linha.substring(3,5));
		Integer year = new Integer(linha.substring(6,10));
		return createDate(day, month, year);
	}

	private static boolean isPurchaseLine(String linha) {
		return linha.contains("US$") && linha.contains("R$") && hasDate(linha);
	}

	private static boolean hasDate(String linha) {
		try {
			String substring = linha.substring(0, 10);
			Integer day = new Integer(substring.substring(0,2));
			Integer month = new Integer(substring.substring(3,5));
			Integer year = new Integer(substring.substring(6,10));
			return true;
			
		}catch (IndexOutOfBoundsException e) {
			return false;
		}catch (NumberFormatException e) {
			return false;
		}
	}

	private static Date createDate(int day, int month, int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(2013, Calendar.JANUARY, 9);
		return cal.getTime();
	}

	private static void saveBill(Bill bill) {
		
	}

	private static Bill buildBill(Bank bank, List<String> lines) {
		return bank.buildBill(lines);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringPropertiesApplication.class);
	}
}