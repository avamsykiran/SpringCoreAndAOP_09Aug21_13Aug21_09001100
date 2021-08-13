package com.cts.bta.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cts.bta.model.Transaction;
import com.cts.bta.model.TransactionType;
import com.cts.bta.service.TransactionsService;

@Component("starter")
public class Starter {

	@Value("${bta.title}")
	private String title;
	
	@Autowired
	@Qualifier("kbin")
	private Scanner kbin;
	
	@Autowired
	@Qualifier("dateFormat")
	private DateTimeFormatter dtFormat;
	
	@Autowired
	private TransactionsService txnService;
	
	public void start() {
		System.out.println(title);
		System.out.println("=====================================");
		
		Menu choice=null;
		String askForChoices = String.format("Enter Choice %s> ",Arrays.asList(Menu.values()));
		
		while(choice!=Menu.QUIT) {
			System.out.println(askForChoices);
			choice = Menu.valueOf(kbin.next().toUpperCase());
			
			switch(choice) {
			case ADD: 
				add(); 
				break;
			case LIST: 
				list();
				break;
			case DELETE:
				delete(); 
				break;
			case QUIT: 
				System.out.println("Applciation Termianted");
				break;
			}
		}
	}
	
	private void add() {
		
		Transaction txn = new Transaction();
		System.out.print("TxnId> ");
		txn.setTxId(kbin.nextLong());
		System.out.print("Header> ");
		txn.setHeader(kbin.next());
		System.out.print("Amonut> ");
		txn.setAmount(kbin.nextDouble()); 
		System.out.print("Type(INCOME/EXPENSE)> ");
		txn.setType(TransactionType.valueOf(kbin.next().toUpperCase()));
		txn.setDateOfTransaction(LocalDate.now());
		txnService.add(txn);
		System.out.println("Transaction Recorded");
	}
	
	private void list() {
		txnService.
		getAll().
		stream().
		forEach(t -> System.out.println(
				String.format("%d\t%s\t%s\t%.2f\t%s", 
						t.getTxId(),
						t.getHeader(),
						dtFormat.format(t.getDateOfTransaction()),
						t.getAmount(),
						t.getType())
				));
		System.out.println("Total Income: "+txnService.getTotalIncome());
		System.out.println("Total Expendeture: "+txnService.getTotalExpendeture());
		System.out.println("Balance: "+txnService.getCurrentBalance());
	}
	
	private void delete() {
		System.out.print("TxnId> ");
		long txid = kbin.nextLong();
		txnService.delete(txid);
		System.out.println("Record Removed");
	}
}

