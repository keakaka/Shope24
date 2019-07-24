package com.cafe24.shope24.repository;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shope24.vo.CategoryVo;

@Repository
public class AdminDao {
	
	@Autowired
	private SqlSession sqlSession;

	public CategoryVo insertCategory(CategoryVo vo) {
		if(sqlSession.insert("admin.insertCategory", vo) == 1) {
			return vo;
		} else {
			return null;
		}
	}

	public ArrayList<CategoryVo> getCategoryList() {
		return (ArrayList)sqlSession.selectList("admin.getCategoryList");
	}
	
	
	
}
