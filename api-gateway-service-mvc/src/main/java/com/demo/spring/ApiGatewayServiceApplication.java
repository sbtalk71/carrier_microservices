package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ApiGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayServiceApplication.class, args);
	}

	@GetMapping("/hrFallback")
	public ResponseEntity<String> hrFallback(){
		return ResponseEntity.ok("Hr Service is Unavailable");
	}
	
	
	
	/*
	 * @Bean public RouteLocator routesConfig(RouteLocatorBuilder rb) { return
	 * rb.routes() .route(r->r.path("/hr/**") .filters(
	 * f->f.circuitBreaker(config->config.setFallbackUri("/hrFallback")
	 * .setName("hrService"))) .uri("lb://hr-service"))
	 * .route(r->r.path("/emp/**").uri("lb://emp-service"))
	 * .route(r->r.path("/test/**").uri("http://www.google.co.in")) .build(); }
	 */
	
}
