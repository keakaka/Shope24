package com.cafe24.shope24.dto;

import java.util.List;

import com.cafe24.shope24.vo.DisplayProductVo;
import com.cafe24.shope24.vo.FileVo;
import com.cafe24.shope24.vo.ProductVo;

public class DisplayProductDTO {
	
	private Long no;
	private String title;
	private String content;
	private String date;
	private Long order;
	private String status;
	private Long categoryNo;
	
	private List<ProductVo> productList;
	private List<FileVo> fileList;
	
	public Long getNo() {
		return no;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getDate() {
		return date;
	}
	public Long getOrder() {
		return order;
	}
	public String getStatus() {
		return status;
	}
	public Long getCategoryNo() {
		return categoryNo;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setOrder(Long order) {
		this.order = order;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}
	public List<ProductVo> getProductList() {
		return productList;
	}
	public List<FileVo> getFileList() {
		return fileList;
	}
	public void setProductList(List<ProductVo> productList) {
		this.productList = productList;
	}
	public void setFileList(List<FileVo> fileList) {
		this.fileList = fileList;
	}
	@Override
	public String toString() {
		return "DisplayProductDTO [no=" + no + ", title=" + title + ", content=" + content + ", date=" + date
				+ ", order=" + order + ", status=" + status + ", categoryNo=" + categoryNo + ", productList="
				+ productList + ", fileList=" + fileList + "]";
	}
	
}

