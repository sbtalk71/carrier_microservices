package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/hr")
public class HrController {

	@Autowired
	RestTemplate rt;
	
	@GetMapping(path="/emp/{id}")
	@CircuitBreaker(name = "hrBackend",fallbackMethod = "getEmpDetailsFallback")
	public ResponseEntity getEmpDetails(@PathVariable int id) {
		return rt.getForEntity("http://emp-service/emp/"+id, String.class);
	}
	
	
	public ResponseEntity getEmpDetailsFallback(Throwable t) {
		return ResponseEntity.ok("Service Unavailable..");
	}
}
