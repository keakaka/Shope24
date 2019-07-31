package com.cafe24.shope24.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shope24.dto.DisplayProductDTO;
import com.cafe24.shope24.dto.JSONResult;
import com.cafe24.shope24.service.ProductService;
import com.cafe24.shope24.vo.CartVo;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private MessageSource msgSource;
	@Autowired
	private ProductService productService;
	
	@ApiOperation(value="상품 리스트 화면")
	@GetMapping()
	public ResponseEntity<JSONResult> productList() {
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
	}
	
	@ApiOperation(value="특정 상품 조회")
	@GetMapping("/{displayProductNo}")
	public ResponseEntity<JSONResult> getProduct(@PathVariable(value="displayProductNo") Long displayProductNo) {
		
		DisplayProductDTO dto = productService.getProduct(displayProductNo);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(dto));
	}
	
	@ApiOperation(value="장바구니 담기")
	@PostMapping("/addCart")
	public ResponseEntity<JSONResult> getProduct( @RequestBody CartVo vo) {
		
		Boolean check = productService.insertCart(vo);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
	}
	
}
