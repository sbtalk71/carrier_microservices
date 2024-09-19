package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(
				sec->sec.requestMatchers("/hr").authenticated()
				.requestMatchers("/emp").authenticated()
				.anyRequest().permitAll());
		http.httpBasic(Customizer.withDefaults());
		return http.build();
		
	}
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("shantanu").password("$2a$10$pfqcUCiE4WVHYzf1MrAvDOz7XsgmFoU6i8YxtG0XeYNIOOZnEBIMO");
		auth.inMemoryAuthentication().withUser("pavan").password("$2a$10$pfqcUCiE4WVHYzf1MrAvDOz7XsgmFoU6i8YxtG0XeYNIOOZnEBIMO");
		auth.inMemoryAuthentication().withUser("venkat").password("$2a$10$pfqcUCiE4WVHYzf1MrAvDOz7XsgmFoU6i8YxtG0XeYNIOOZnEBIMO");
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
