package com.cafe24.shope24.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.shope24.dto.JSONResult;
import com.cafe24.shope24.vo.CategoryVo;
import com.cafe24.shope24.vo.MemberVo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class AdminService {
	
	private RestTemplate restTemplate = new RestTemplate();

	public List<CategoryVo> getCategoryList() {
		
		ResponseEntity<JSONResult> result = 
				restTemplate.getForEntity("http://localhost:8080/Shope24_Backend/api/admin/productManager/category", JSONResult.class);
		
		List<CategoryVo> list = new Gson().fromJson(result.getBody().getData().toString(), new TypeToken<List<CategoryVo>>(){}.getType());
		
		return list;
	}
	
}
