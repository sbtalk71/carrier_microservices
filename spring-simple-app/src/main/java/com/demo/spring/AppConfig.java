package com.demo.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "com.demo.spring")
@Configuration
public class AppConfig {

	
	//@Bean
	protected PlainTextWriter writer() {
		return new PlainTextWriter();
	}
}
