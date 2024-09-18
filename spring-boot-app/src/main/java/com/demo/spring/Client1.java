package com.demo.spring;

import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties.Restclient;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

public class Client1 {

	public static void main(String[] args) {
		RestTemplate rt = new RestTemplate();

		String response = rt.getForObject("http://localhost:8081/emp/102", String.class);

		System.out.println(response);

		String response1 = RestClient.create().get().uri("http://localhost:8081/emp/102")
				.accept(MediaType.APPLICATION_JSON).retrieve().body(String.class);

		System.out.println(response1);

		Emp response2 = RestClient.create().get().uri("http://localhost:8081/emp/102")
				.accept(MediaType.APPLICATION_JSON).retrieve().body(Emp.class);

		System.out.println(response1);

		System.out.println(response2);

	}

}
