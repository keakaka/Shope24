package com.cafe24.shope24.vo;

public class CategoryVo {
	
	private Long no;
	private String name;
	private Long refNo;
	private Long level;
	
	public Long getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public Long getRefNo() {
		return refNo;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRefNo(Long refNo) {
		this.refNo = refNo;
	}
	
	public Long getLevel() {
		return level;
	}
	public void setLevel(Long level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", name=" + name + ", refNo=" + refNo + ", level=" + level + "]";
	}
	
	
}
