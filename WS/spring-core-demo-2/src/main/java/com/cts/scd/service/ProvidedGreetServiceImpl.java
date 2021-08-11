package com.cts.scd.service;

public class ProvidedGreetServiceImpl implements GreetService{

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
