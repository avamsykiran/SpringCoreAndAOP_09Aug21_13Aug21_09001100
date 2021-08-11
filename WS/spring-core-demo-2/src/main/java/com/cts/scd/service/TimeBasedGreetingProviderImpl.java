package com.cts.scd.service;

import java.time.LocalTime;

public class TimeBasedGreetingProviderImpl implements GreetingProvider{

	@Override
	public String getGreeting() {
		String greeting="";
		
		int h = LocalTime.now().getHour();
		
		if(h>=3 && h<=11) greeting="Good Morning";
		else if(h>11 && h<=15) greeting="Good Noon";
		else greeting="Good Evening";
		
		return greeting;
	}

}
