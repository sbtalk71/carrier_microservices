package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class WriterApp {

	@Autowired
	@Qualifier("plainTextWriter")
	private Writer writer;
	
	public void printMessage(String message) {
		
		writer.write(message);
	}
	
}
