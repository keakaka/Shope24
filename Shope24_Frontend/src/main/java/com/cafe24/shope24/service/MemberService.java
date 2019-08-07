package com.cafe24.shope24.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.cafe24.shope24.dto.JSONResult;
import com.cafe24.shope24.vo.MemberVo;

@Service
public class MemberService {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public Boolean checkId(String id) {
		
		Boolean result = restTemplate.getForObject("http://localhost:8080/Shope24_Backend/api/member/checkId?"+"id="+id, Boolean.class);
		
		return result;
	}

	public String insertMember(MemberVo memberVo) {
		
		ResponseEntity<JSONResult> result = 
				restTemplate.postForEntity("http://localhost:8080/Shope24_Backend/api/member/join", memberVo, JSONResult.class);
		
		if("fail".equals(String.valueOf(result.getBody().getResult()))) {
			return result.getBody().getMessage();
		}else {
			return result.getBody().getResult();
		}
		
	}
	
}
