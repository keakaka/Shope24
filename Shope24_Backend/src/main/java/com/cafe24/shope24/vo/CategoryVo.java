package com.cafe24.shope24.vo;

public class CategoryVo {
	
	private Long no;
	private String name;
	private Long groupNo;
	private Long groupSeq;
	private Long depth;
	private String status;
	
	public Long getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public Long getGroupNo() {
		return groupNo;
	}
	public Long getGroupSeq() {
		return groupSeq;
	}
	public Long getDepth() {
		return depth;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGroupNo(Long groupNo) {
		this.groupNo = groupNo;
	}
	public void setGroupSeq(Long groupSeq) {
		this.groupSeq = groupSeq;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", name=" + name + ", groupNo=" + groupNo + ", groupSeq=" + groupSeq
				+ ", depth=" + depth + ", status=" + status + "]";
	}
	
}
