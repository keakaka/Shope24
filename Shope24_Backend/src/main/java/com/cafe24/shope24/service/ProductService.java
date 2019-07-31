package com.cafe24.shope24.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shope24.dto.DisplayProductDTO;
import com.cafe24.shope24.repository.ProductDao;
import com.cafe24.shope24.vo.CartVo;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	public DisplayProductDTO getProduct(Long displayProductNo) {
		
		return productDao.getProduct(displayProductNo);
	}

	public Boolean insertCart(CartVo vo) {
		
		return productDao.insertCart(vo);
	}
	
}
