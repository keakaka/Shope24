package com.cafe24.shope24.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.shope24.dto.JSONResult;
import com.cafe24.shope24.dto.ProductDTO;
import com.cafe24.shope24.vo.CategoryVo;
import com.cafe24.shope24.vo.FileVo;
import com.cafe24.shope24.vo.MemberVo;
import com.cafe24.shope24.vo.OptionVo;
import com.cafe24.shope24.vo.ProductVo;
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

	public void insertProduct(Map<String, Object> productDTO) {
		
		// 진열 상품
		ProductDTO dto = new ProductDTO();
		dto.setTitle(String.valueOf(productDTO.get("title")));
		dto.setContent(String.valueOf(productDTO.get("content")));
		dto.setCategoryNo(Long.parseLong(String.valueOf(productDTO.get("categoryNo"))));
		
		// 상품
		ProductVo product = null;
		String name = String.valueOf(productDTO.get("name"));
		Long stock = Long.parseLong(String.valueOf(productDTO.get("stock")));
		Long price = Long.parseLong(String.valueOf(productDTO.get("price")));
		List<ProductVo> productList = new ArrayList<ProductVo>();
		List<OptionVo> optionList = (List<OptionVo>) productDTO.get("optionList");
		for(Object o : optionList) {
			product = new ProductVo();
			product.setName(name);
			product.setStock(stock);
			product.setPrice(price);
			product.setOption(String.valueOf(o));
			productList.add(product);
		}
		dto.setProductList(productList);
		
		// 상품 이미지
		List<FileVo> fList = (List<FileVo>) productDTO.get("fileList");
		List<FileVo> fileList = new ArrayList<FileVo>();
		FileVo fileVo = null;
		for(Object o : fList) {
			fileVo = new FileVo();
			fileVo.setUrl(String.valueOf(o));
			fileList.add(fileVo);
		}
		dto.setFileList(fileList);
		ResponseEntity<JSONResult> result = 
				restTemplate.postForEntity("http://localhost:8080/Shope24_Backend/api/admin/productManager/product", dto, JSONResult.class);
		
		// API Server에 DTO 넘기기까지 했음. 
		// 현재 api 서버 리턴값 스트링이니까 확인하고, Boolean 으로 바꿔줘야 함.
		// front controller 까지 처리.
		
	}
	
}
