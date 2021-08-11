package com.cts.scd.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.scd.service.GreetService;

public class App02 {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans02.xml");

		GreetService greetService1 = (GreetService) context.getBean("gs1");
		System.out.println(greetService1.hashCode());

		GreetService greetService2 = (GreetService) context.getBean("gs1");
		System.out.println(greetService2.hashCode());

		GreetService greetService3 = (GreetService) context.getBean("gs1");
		System.out.println(greetService3.hashCode());
		
	}

}
