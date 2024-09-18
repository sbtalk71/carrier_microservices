package com.demo.spring;

import org.springframework.stereotype.Repository;

@Repository
public class DecoratedWriter implements Writer{

	@Override
	public void write(String message) {
		System.out.println("Decorated Writer :"+message);
		
	}

}
