package com.cafe24.shope24.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.cafe24.shope24.dto.JSONResult;
import com.cafe24.shope24.vo.CategoryVo;
import com.cafe24.shope24.vo.MemberVo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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

	public MemberVo getMember(MemberVo memberVo) {
		ResponseEntity<JSONResult> result = 
				restTemplate.postForEntity("http://localhost:8080/Shope24_Backend/api/member/login", memberVo, JSONResult.class);
		MemberVo vo = null;
		if("success".equals(String.valueOf(result.getBody().getResult()))) {
			vo = new Gson().fromJson(result.getBody().getData().toString(), MemberVo.class);
			return vo;
		}else {
			return vo;
		}
	}

	public MemberVo getAdmin(MemberVo memberVo) {
		
		ResponseEntity<JSONResult> result = 
				restTemplate.postForEntity("http://localhost:8080/Shope24_Backend/api/admin/login", memberVo, JSONResult.class);
		MemberVo vo = null;
		if("success".equals(String.valueOf(result.getBody().getResult()))) {
			vo = new Gson().fromJson(result.getBody().getData().toString(), MemberVo.class);
			return vo;
		}else {
			return vo;
		}
	}

	public List<MemberVo> getmemberList() {
		
		ResponseEntity<JSONResult> result = 
				restTemplate.getForEntity("http://localhost:8080/Shope24_Backend/api/admin/memberList", JSONResult.class);
		System.out.println(result);
		System.out.println(result.getBody());
		System.out.println(result.getBody().getData());
		
		List list = null;
		if("success".equals(String.valueOf(result.getBody().getResult()))) {
			
			list = new Gson().fromJson(result.getBody().getData().toString(), new TypeToken<List<MemberVo>>(){}.getType());
			return list;
		}else {
			return list;
		}
		
	}

}
