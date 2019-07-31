package com.cafe24.shope24.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shope24.dto.DisplayProductDTO;
import com.cafe24.shope24.vo.CartVo;

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
}
