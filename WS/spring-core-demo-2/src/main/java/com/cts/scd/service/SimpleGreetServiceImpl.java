package com.cts.scd.service;

import org.springframework.stereotype.Service;

@Service("gs1")
public class SimpleGreetServiceImpl implements GreetService{

	@Override
	public String greet(String userName) {
		return "Hello " + userName;
	}

}
