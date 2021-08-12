package com.cts.scd.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MultiLangualGreetingProviderImpl implements GreetingProvider{

	@Value("#{${provider.greetings}}")
	private Map<String,String> greetings;
	
	@Value("${provider.lang}")
	private String selectedLanguage;
	
	@Override
	public String getGreeting() {
		return greetings.get(selectedLanguage);
	}

	public Map<String, String> getGreetings() {
		return greetings;
	}

	public void setGreetings(Map<String, String> greetings) {
		this.greetings = greetings;
	}

	public String getSelectedLanguage() {
		return selectedLanguage;
	}

	public void setSelectedLanguage(String selectedLanguage) {
		this.selectedLanguage = selectedLanguage;
	}

	
}
