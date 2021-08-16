package com.cts.aopdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.cts.aopdemo.service.GreetService;

@Configuration
@ComponentScan("com.cts.aopdemo")
@EnableAspectJAutoProxy
public class SpringAOPDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(SpringAOPDemoApplication.class);
		
		GreetService gs = (GreetService) context.getBean("gs");
		System.out.println(gs.greet("Vamsy"));
		
	}

}
