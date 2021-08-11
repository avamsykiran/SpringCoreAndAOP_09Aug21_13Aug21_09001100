package com.cts.scd.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.scd.service.GreetService;

public class App03 {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans03.xml");
		
		GreetService greetService5 = (GreetService) context.getBean("gs5");
		System.out.println(greetService5.greet("Vamsy"));
	}

}
