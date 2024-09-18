package com.demo.spring.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="emp-service",path = "/emp")
public interface EmpClient {

	@GetMapping()
	public String getAllEmps(); 
	
	@GetMapping(path="/{id}",produces =MediaType.APPLICATION_JSON_VALUE )
	public String getByid(@PathVariable Integer id);
	
}
