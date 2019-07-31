package com.cafe24.shope24.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shope24.dto.DisplayProductDTO;
import com.cafe24.shope24.dto.JSONResult;
import com.cafe24.shope24.service.AdminService;
import com.cafe24.shope24.vo.CategoryVo;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
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
		List<CategoryVo> list = adminService.getCategoryList();
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	@ApiOperation(value="카테고리 추가")
	@PostMapping("/productManager/category")
	public ResponseEntity<JSONResult> insertCategory( @RequestBody CategoryVo vo ) {
		CategoryVo returnVo = adminService.insertCategory(vo);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(returnVo));
	}
	
	@ApiOperation(value="카테고리 삭제")
	@DeleteMapping("/productManager/category")
	public JSONResult deleteCategory( @RequestBody CategoryVo vo ) {
		Boolean check = adminService.deleteCategory(vo);
		return JSONResult.success(check?"삭제 성공":"삭제 실패");
	}
	
	@ApiOperation(value="카테고리 수정")
	@PutMapping("/productManager/category")
	public ResponseEntity<JSONResult> UpdateCategory( @RequestBody ArrayList<CategoryVo> list  ) {
		Boolean check = adminService.updateCategory(list);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(check?"수정 성공":"수정 실패"));
	}
	
	@ApiOperation(value="상품 조회")
	@GetMapping("/productManager/product")
	public JSONResult showProduct() {
		
		
		return JSONResult.success(null);
	}
	
	@ApiOperation(value="상품 등록 폼")
	@GetMapping("/productManager/showInsertProductForm")
	public ResponseEntity<JSONResult> showInsertProductForm() {
		List<CategoryVo> list = adminService.getCategoryList();
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	@ApiOperation(value="상품 등록")
	@PostMapping("/productManager/product")
	public JSONResult insertProduct( @RequestBody DisplayProductDTO dto ) {
		Boolean check = adminService.insertProduct(dto);
		
		return JSONResult.success(check?"등록성공":"등록실패");
	}
	
	@ApiOperation(value="상품 수정")
	@PutMapping("/productManager/product")
	public JSONResult updateProduct() {
		return JSONResult.success(null);
	}
	
	@ApiOperation(value="고객 관리")
	@GetMapping("/customerManager")
	public JSONResult customerManagement() {
		return JSONResult.success(null);
	}
	
	@ApiOperation(value="회원 탈퇴 처리")
	@DeleteMapping("/customerManager")
	public JSONResult DeleteMember() {
		return JSONResult.success(null);
	}
	
	@ApiOperation(value="주문 관리")
	@GetMapping("/orderManager")
	public JSONResult ordermanagement() {
		return JSONResult.success(null);
	}
	
	@ApiOperation(value="주문 정보 업데이트")
	@PutMapping("/orderManager")
	public JSONResult updateOrder() {
		return JSONResult.success(null);
	}
	
	
}
