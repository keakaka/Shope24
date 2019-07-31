package com.cafe24.shope24.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.shope24.dto.DisplayProductDTO;
import com.cafe24.shope24.repository.AdminDao;
import com.cafe24.shope24.vo.CategoryVo;
import com.cafe24.shope24.vo.DisplayProductVo;
import com.cafe24.shope24.vo.FileVo;
import com.cafe24.shope24.vo.ProductVo;
@Service
@Transactional
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	public CategoryVo insertCategory(CategoryVo vo) {
		// 그룹 넘버가 지정되었을 때는 기존 데이터의 그룹 시퀀스를 증가시켜준 뒤 인서트 작업을 실시한다.
		if(vo.getGroupNo() != null) {
			adminDao.updateGroupSeq(vo);
		}
		return adminDao.insertCategory(vo);
		
	}

	public ArrayList<CategoryVo> getCategoryList() {
		return adminDao.getCategoryList();
	}
	
	public Boolean deleteCategory(CategoryVo vo) {
		// 해당 카테고리 참조상품 유무 체크
		Boolean productCheck = adminDao.productCheck(vo.getNo());
		if(productCheck) {
			return false;
		}
		
		// 해당 그룹시퀀스보다 큰 그룹 시퀀스를 낮추는 작업을 진행한다.
		// 해당 작업은 업데이트가 될 수도, 안될 수도 있기에 리턴 void로 구성한다.
		adminDao.groupSeqDown(vo);
		
		return adminDao.deleteCategory(vo);
	}

	public Boolean updateCategory(ArrayList<CategoryVo> list) {
		
		return adminDao.updateCategory(list);
	}

	public Boolean insertProduct(DisplayProductDTO dto) {
		
		// 가장 먼저 선행 되야 할 DisplayProduct 를 이용하는 DTO에 Data를 담아 순차적 Insert 작업을 진행한다.
		List<ProductVo> productList = dto.getProductList();
		List<FileVo> fileList = dto.getFileList();
		
		Long displayProductNo = adminDao.insertDisplayProduct(dto);
		for(FileVo vo : fileList) {
			vo.setDisplayProductNo(displayProductNo);
		}
		adminDao.insertFile(fileList);
		
		for(ProductVo vo : productList) {
			vo.setDisplayProductNo(displayProductNo);
		}
		
		adminDao.insertProduct(productList);
		
		return true;
	}
	
}
