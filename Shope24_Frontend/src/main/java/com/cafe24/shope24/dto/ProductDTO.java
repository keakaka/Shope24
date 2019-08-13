package com.cafe24.shope24.dto;

import java.util.List;

import com.cafe24.shope24.vo.FileVo;
import com.cafe24.shope24.vo.OptionVo;
import com.cafe24.shope24.vo.ProductVo;

public class ProductDTO {
	
	// 진열 상품
	private Long displayProductNo;
	private Long categoryNo;
	private String title;
	private String content;
	
	// 상품 이미지
	private List<FileVo> fileList;
	
	// 상품
	private List<ProductVo> productList;
	private String name;

	// 옵션
	private List<OptionVo> optionList;

	public Long getDisplayProductNo() {
		return displayProductNo;
	}

	public Long getCategoryNo() {
		return categoryNo;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public List<FileVo> getFileList() {
		return fileList;
	}

	public List<ProductVo> getProductList() {
		return productList;
	}

	public List<OptionVo> getOptionList() {
		return optionList;
	}

	public void setDisplayProductNo(Long displayProductNo) {
		this.displayProductNo = displayProductNo;
	}

	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setFileList(List<FileVo> fileList) {
		this.fileList = fileList;
	}

	public void setProductList(List<ProductVo> productList) {
		this.productList = productList;
	}

	public void setOptionList(List<OptionVo> optionList) {
		this.optionList = optionList;
	}

	@Override
	public String toString() {
		return "ProductDTO [displayProductNo=" + displayProductNo + ", categoryNo=" + categoryNo + ", title=" + title
				+ ", content=" + content + ", fileList=" + fileList + ", productList=" + productList + ", optionList="
				+ optionList + "]";
	}
	
	
	
	
}
