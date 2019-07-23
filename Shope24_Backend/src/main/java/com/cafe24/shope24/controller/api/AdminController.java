package com.cafe24.shope24.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shope24.dto.JSONResult;
import com.cafe24.shope24.vo.CategoryVo;
import com.cafe24.shope24.vo.MemberVo;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@ApiOperation(value="어드민 메인페이지")
	@GetMapping()
	public ResponseEntity<JSONResult> adminMain() {
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
	}
	
	@ApiOperation(value="상품관리")
	@GetMapping("/productManager")
	public ResponseEntity<JSONResult> productManagement() {
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
	}
	
	@ApiOperation(value="카테고리 조회")
	@GetMapping("/productManager/category")
	public ResponseEntity<JSONResult> showCategory() {
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
	}
	
	@ApiOperation(value="카테고리 추가")
	@PostMapping("/productManager/category")
	public ResponseEntity<JSONResult> insertCategory( @RequestBody CategoryVo vo ) {
		
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
	}
	
	@ApiOperation(value="카테고리 삭제")
	@DeleteMapping("/productManager/category")
	public JSONResult deleteCategory() {
		return JSONResult.success(null);
	}
	
	
	
	
	
}
