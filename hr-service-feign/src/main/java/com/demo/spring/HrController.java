package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.feign.EmpClient;

@RestController
@RequestMapping("/hr")
public class HrController {

	@Autowired
	RestTemplate rt;
	
	@Autowired
	EmpClient client;
	
	
	@GetMapping(path="/emp/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getEmpDetails(@PathVariable int id) {
		//return rt.getForEntity("http://emp-service/emp/"+id, String.class);
		return ResponseEntity.ok(client.getByid(id));
	}
	
	
	@GetMapping(path="/",produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity getAllEmps() {
		return ResponseEntity.ok(client.getAllEmps());
	}
}
