package com.cts.bta;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.cts.bta.ui.Starter;

@Configuration
@ComponentScan("com.cts.bta")
@PropertySource("classpath:application.properties")
public class BudgetTrackingApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BudgetTrackingApplication.class);
		((Starter) context.getBean("starter")).start();
	}
	
	@Bean
	public Scanner kbin() {
		return new Scanner(System.in);
	}
	
	@Bean
	public DateTimeFormatter dateFormat(@Value("${bta.date.format}") String pattern) {
		return DateTimeFormatter.ofPattern(pattern);
	}

}
