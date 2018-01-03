package br.com.configuration;

import java.io.File;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import br.com.model.Bank;
import br.com.model.Bill;
import br.com.model.Santander;
import br.com.service.FileService;

//@RestController
//@EnableJpaRepositories("br.com.repository")
//@EntityScan("br.com.model")
//@ComponentScan("br.com.controllers")
@SpringBootApplication
public class SpringPropertiesApplication extends SpringBootServletInitializer {

	private static final String FILE_PATH = "C:\\Users\\Mica\\Downloads\\faturas\\comprovante6B210B26D52533668E90EC19.pdf";

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringPropertiesApplication.class, args);
		
		List<String> lines = new FileService().getLinesFromPdf(new File(FILE_PATH));
		Bill bill = getBill(new Santander(), lines);
		saveBill(bill);
		
		for (int i = 0; i < lines.size(); i++) {
			System.out.println("line " + i + ": " + lines.get(i));
		}
		
	}

	private static void saveBill(Bill bill) {
		
	}

	private static Bill getBill(Bank bank, List<String> lines) {
		return bank.buildBill(lines);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringPropertiesApplication.class);
	}
}