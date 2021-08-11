package com.cts.scd.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.scd.conf.ConfiguarationDemo;
import com.cts.scd.service.GreetService;

public class App01 {

	public static void main(String[] args) {
	
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfiguarationDemo.class);
		
		GreetService greetService1 = (GreetService) context.getBean("gs1");
		System.out.println(greetService1.greet("Vamsy"));
		
		GreetService greetService2 = (GreetService) context.getBean("gs2");
		System.out.println(greetService2.greet("Vamsy"));
	}

}
