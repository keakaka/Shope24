package com.cafe24.shope24.vo;

public class DeliveryAddressVo {
	private Long no;
	private Long memberNo;
	private String address;
	private String type;
	@Override
	public String toString() {
		return "DeliveryAddressVo [no=" + no + ", memberNo=" + memberNo + ", address=" + address + ", type=" + type
				+ "]";
	}
	public Long getNo() {
		return no;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public String getAddress() {
		return address;
	}
	public String getType() {
		return type;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
