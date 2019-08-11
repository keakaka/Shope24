package com.cafe24.shope24.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shope24.dto.DisplayProductDTO;
import com.cafe24.shope24.vo.CategoryVo;
import com.cafe24.shope24.vo.DisplayProductVo;
import com.cafe24.shope24.vo.FileVo;
import com.cafe24.shope24.vo.MemberVo;
import com.cafe24.shope24.vo.ProductVo;

@Repository
public class AdminDao {
	
	@Autowired
	private SqlSession sqlSession;

	private final String key = "FeelSoGoooooood";
	
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

	public void updateGroupSeq(CategoryVo vo) {
		sqlSession.update("admin.updateGroupSeq", vo);
	}

	public Boolean deleteCategory(CategoryVo vo) {
		return sqlSession.delete("admin.deleteCategory", vo) == 1;
	}

	public Boolean productCheck(Long no) {
		
		return false;
	}

	public void groupSeqDown(CategoryVo vo) {
		sqlSession.update("admin.groupSeqDown", vo);
	}

	public Boolean updateCategory(List<CategoryVo> list) {
		
		return sqlSession.update("admin.updateCategory", list) > 0;
	}

	public Long insertDisplayProduct(DisplayProductDTO dto) {
		
		sqlSession.insert("admin.insertDisplayProduct", dto);
		
		return dto.getNo();
	}

	public int insertFile(List<FileVo> fileList) {
		
		return sqlSession.insert("admin.insertFile", fileList);
	}

	public int insertProduct(List<ProductVo> productList) {
		return sqlSession.insert("admin.insertProduct", productList);
	}

	public ArrayList<MemberVo> getMemberList() {
		return (ArrayList)sqlSession.selectList("admin.getMemberList", key);
	}
	
	
	
}
