package com.demo.spring;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyPwdEncoder {

	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("welcome1"));

	}

}
