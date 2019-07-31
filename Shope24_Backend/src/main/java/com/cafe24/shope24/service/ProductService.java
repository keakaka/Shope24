package com.cafe24.shope24.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.shope24.dto.DisplayProductDTO;
import com.cafe24.shope24.dto.OrdersDTO;
import com.cafe24.shope24.repository.ProductDao;
import com.cafe24.shope24.vo.CartVo;
import com.cafe24.shope24.vo.OrdersDetailVo;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	public DisplayProductDTO getProduct(Long displayProductNo) {
		
		return productDao.getProduct(displayProductNo);
	}

	public Boolean insertCart(CartVo vo) {
		
		return productDao.insertCart(vo);
	}

	public Boolean insertOrders(OrdersDTO dto) {
		
		dto.setOrdersCode(new SimpleDateFormat("yyyyMMdd").format(new Date()) + "-" + productDao.getTodayOrderCount());
		
		Long ordersNo = productDao.insertOrders(dto);
		
		for(OrdersDetailVo vo : dto.getOrdersDetailList()) {
			vo.setOrdersNo(ordersNo);
		}
		
		productDao.insertOrdersDetail(dto.getOrdersDetailList());
		
		return true;
	}
	
}
