package com.cafe24.shope24.service;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MemberService {
	
//	public RestTemplate getRestTemplate() {
//		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(); 
//		factory.setReadTimeout(5000); // 읽기시간초과, ms 
//		factory.setConnectTimeout(3000); // 연결시간초과, ms 
//		HttpClient httpClient = HttpClientBuilder.create() .setMaxConnTotal(100) // connection pool 적용 
//				.setMaxConnPerRoute(5) // connection pool 적용 
//				.build(); 
//		factory.setHttpClient(httpClient); // 동기실행에 사용될 HttpClient 세팅 
//		return new RestTemplate(factory);
//		
//	}
	
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}
	
	public Boolean checkId(String id) {
		
		RestTemplate temp = restTemplate();
		
		Boolean result = temp.getForObject("http://localhost:8080/Shope24_Backend/api/member/checkId?"+"id="+id, Boolean.class);
		
		System.out.println(result);
		
		return null;
	}
	
		
	
}
