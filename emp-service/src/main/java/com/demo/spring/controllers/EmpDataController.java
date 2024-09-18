package com.demo.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.EmpService;
import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;
import com.demo.spring.util.Message;

@RestController
@RequestMapping("/emp")
public class EmpDataController {
	@Autowired
	EmpService empService;

	// GET http://localhost:8081/emp/greet
	// @RequestMapping(path = "/greet", method = RequestMethod.GET)
	@GetMapping(path = "/greet")
	public String greet() {
		return "Hello from Spring";
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Emp>> getEmpList() {

		return ResponseEntity.ok(empService.findAllEmps());
	}

	// GET http://localhost:8081/emp/100
	@GetMapping(path = "/{eid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Emp> findOneEmp(@PathVariable("eid") Integer id) {
		return ResponseEntity.ok(empService.findById(id));
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Emp> addEmp(@RequestBody Emp e) {
		return ResponseEntity.ok(empService.save(e));
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Emp> updateEmp(@RequestBody Emp e) {
		return ResponseEntity.ok(empService.updateEmp(e));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Message> deleteEmp(@PathVariable Integer id) {
		empService.deleteEmp(id);

		return ResponseEntity.ok(new Message("Deleted"));

	}

	/*
	 * @ExceptionHandler(RuntimeException.class) public ResponseEntity<String>
	 * handleException(RuntimeException ex){ String data=""" {"status":%s} """;
	 * 
	 * return ResponseEntity.ok(String.format(data, ex.getMessage())); }
	 */

}
