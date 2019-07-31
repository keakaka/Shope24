package com.cafe24.shope24.vo;

public class DisplayProductVo {
	
	private Long no;
	private String title;
	private String content;
	private String date;
	private Long order;
	private String status;
	private Long categoryNo;
	
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
	@Override
	public String toString() {
		return "DisplayProductVo [no=" + no + ", title=" + title + ", content=" + content + ", date=" + date
				+ ", order=" + order + ", status=" + status + ", categoryNo=" + categoryNo + "]";
	}
	
}
