package com.demo.spring;

import org.springframework.stereotype.Repository;

@Repository
public class PlainTextWriter implements Writer{

	@Override
	public void write(String message) {
		System.out.println("Plain Text Writer :"+message);
		
	}

}
