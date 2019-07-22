package com.cafe24.shope24.vo;

public class CartVo {
	private Long no;
	private Long count;
	private String memberNo;
	private Long productNo;
	
	@Override
	public String toString() {
		return "CartVo [no=" + no + ", count=" + count + ", memberNo=" + memberNo + ", productNo=" + productNo + "]";
	}
	public Long getNo() {
		return no;
	}
	public Long getCount() {
		return count;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public Long getProductNo() {
		return productNo;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}
	
}
