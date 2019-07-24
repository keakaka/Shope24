package com.cafe24.shope24.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.shope24.repository.AdminDao;
import com.cafe24.shope24.vo.CategoryVo;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Transactional
	public CategoryVo insertCategory(CategoryVo vo) {
		return adminDao.insertCategory(vo);
	}

	public ArrayList<CategoryVo> getCategoryList() {
		return adminDao.getCategoryList();
	}
	
}
