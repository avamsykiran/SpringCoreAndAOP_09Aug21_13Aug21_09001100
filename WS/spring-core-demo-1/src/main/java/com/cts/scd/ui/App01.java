package com.cts.scd.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.scd.service.GreetService;

public class App01 {

	public static void main(String[] args) {
		//GreetService greetService = new SimpleGreetServiceImpl();
		//System.out.println(greetService.greet("Vamsy"));
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans01.xml");
		
		GreetService greetService1 = (GreetService) context.getBean("gs1");
		System.out.println(greetService1.greet("Vamsy"));
		
		GreetService greetService2 = (GreetService) context.getBean("gs2");
		System.out.println(greetService2.greet("Vamsy"));
		
		GreetService greetService3 = (GreetService) context.getBean("gs3");
		System.out.println(greetService3.greet("Vamsy"));
		
		GreetService greetService4 = (GreetService) context.getBean("gs4");
		System.out.println(greetService4.greet("Vamsy"));
		
		GreetService greetService5 = (GreetService) context.getBean("gs5");
		System.out.println(greetService5.greet("Vamsy"));
	}

}
