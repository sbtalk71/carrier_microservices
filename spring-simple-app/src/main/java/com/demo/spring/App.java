package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		
		WriterApp app=(WriterApp)context.getBean("writerApp");
		
		app.printMessage("Hello");

	}

}
