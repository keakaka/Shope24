package com.cafe24.shope24.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shope24.dto.DisplayProductDTO;
import com.cafe24.shope24.dto.OrdersDTO;
import com.cafe24.shope24.vo.CartVo;
import com.cafe24.shope24.vo.OrdersDetailVo;

@Repository
public class ProductDao {

	@Autowired
	private SqlSession sqlSession;

	public DisplayProductDTO getProduct(Long displayProductNo) {
		
		return sqlSession.selectOne("product.getDisplayProduct", displayProductNo);
	}

	public Boolean insertCart(CartVo vo) {
		return sqlSession.insert("product.insertCart", vo) == 1;
	}

	public Long insertOrders(OrdersDTO dto) {
		// 추후 암호화 적용 대상
		sqlSession.insert("product.insertOrders", dto);
		
		return dto.getNo();
	}

	public int getTodayOrderCount() {
		return (int)sqlSession.selectOne("product.getTodayOrderCount")+1;
	}

	public void insertOrdersDetail(List<OrdersDetailVo> list) {
		sqlSession.insert("product.insertOrdersDetail", list);
	}
}
