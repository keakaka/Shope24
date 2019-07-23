package com.cafe24.shope24.vo;

public class CategoryVo {
	
	private Long no;
	private String name;
	private Long depth;
	private Long refNo;
	
	public Long getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public Long getDepth() {
		return depth;
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
	public void setDepth(Long depth) {
		this.depth = depth;
	}
	public void setRefNo(Long refNo) {
		this.refNo = refNo;
	}
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", name=" + name + ", depth=" + depth + ", refNo=" + refNo + "]";
	}
	
	
}
