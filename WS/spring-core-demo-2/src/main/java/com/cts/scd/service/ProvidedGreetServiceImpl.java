package com.cts.scd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("gs3")
public class ProvidedGreetServiceImpl implements GreetService{

	@Autowired
	@Qualifier("multiLangualGreetingProviderImpl")
	//@Qualifier("timeBasedGreetingProviderImpl")
	private GreetingProvider greetingProvider;
	
	public ProvidedGreetServiceImpl() {}
	
	public ProvidedGreetServiceImpl(GreetingProvider greetingProvider) {
		super();
		this.greetingProvider = greetingProvider;
	}

	@Override
	public String greet(String userName) {
		return String.format("%s %s", greetingProvider.getGreeting(),userName);
	}

	public GreetingProvider getGreetingProvider() {
		return greetingProvider;
	}

	public void setGreetingProvider(GreetingProvider greetingProvider) {
		this.greetingProvider = greetingProvider;
	}

	
}
