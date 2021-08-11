package com.cts.scd.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("gs2")
public class ArgumentedGreetServiceImpl implements GreetService{

	@Value("Hai")
	private String greeting;
	
	public ArgumentedGreetServiceImpl() {}
			
	public ArgumentedGreetServiceImpl(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public String greet(String userName) {
		return String.format("%s %s", greeting,userName);
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	
}
