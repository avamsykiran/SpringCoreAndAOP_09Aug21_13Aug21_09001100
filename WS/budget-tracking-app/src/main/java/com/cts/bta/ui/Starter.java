package com.cts.bta.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cts.bta.service.TransactionsService;

@Component("starter")
public class Starter {

	@Value("${bta.title}")
	private String title;
	
	@Autowired
	@Qualifier("kbin")
	private Scanner kbin;
	
	@Autowired
	private TransactionsService txnService;
	
	public void start() {
		System.out.println(title);
		System.out.println("=====================================");
	}
}
