package com.demo.spring;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

public class PostClients {

	public static void main(String[] args) {
		
		RestTemplate rt= new RestTemplate();
		
		Emp e= new Emp(106, "Raja", "Chennai", 90000);
		
		HttpHeaders headers=new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept",MediaType.APPLICATION_JSON_VALUE );
		
		HttpEntity<Emp> req= new HttpEntity<Emp>(e, headers);
		
		ResponseEntity<Emp> respData= rt.exchange("http://localhost:8081/emp", HttpMethod.POST, req, Emp.class);
		
		System.out.println(respData.getBody());
		
		
		
		//Put Request as follows:
		
		e.setSalary(80000);
		
		Emp updatedEmpResp=RestClient.create()
											.put()
											.uri("http://localhost:8081/emp")
											.accept(MediaType.APPLICATION_JSON)
											.contentType(MediaType.APPLICATION_JSON)
											.body(e)
											.retrieve()
											.body(Emp.class);
											

		System.out.println(updatedEmpResp);
	}

}
