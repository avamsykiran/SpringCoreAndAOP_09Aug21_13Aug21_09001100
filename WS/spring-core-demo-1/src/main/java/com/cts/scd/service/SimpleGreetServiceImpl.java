package com.cts.scd.service;

public class SimpleGreetServiceImpl implements GreetService{

	@Override
	public String greet(String userName) {
		return "Hello " + userName;
	}

}
