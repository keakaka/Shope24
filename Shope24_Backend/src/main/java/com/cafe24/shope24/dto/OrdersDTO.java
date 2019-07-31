package com.cafe24.shope24.dto;

import java.util.List;

import com.cafe24.shope24.vo.OrdersDetailVo;

public class OrdersDTO {
	private Long no;
	private Long memberNo;
	private String ordersCode;
	private String ordersName;
	private String receiveName;
	private String email;
	private String deliveryAddress;
	private String tel;
	private String phone;
	private Long price;
	private String date;
	private String status;
	
	private List<OrdersDetailVo> ordersDetailList;

	@Override
	public String toString() {
		return "OrdersDTO [no=" + no + ", memberNo=" + memberNo + ", ordersCode=" + ordersCode + ", ordersName="
				+ ordersName + ", receiveName=" + receiveName + ", email=" + email + ", deliveryAddress="
				+ deliveryAddress + ", tel=" + tel + ", phone=" + phone + ", price=" + price + ", date=" + date
				+ ", status=" + status + ", ordersDetailList=" + ordersDetailList + "]";
	}

	public Long getNo() {
		return no;
	}

	public Long getMemberNo() {
		return memberNo;
	}

	public String getOrdersCode() {
		return ordersCode;
	}

	public String getOrdersName() {
		return ordersName;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public String getEmail() {
		return email;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public String getTel() {
		return tel;
	}

	public String getPhone() {
		return phone;
	}

	public Long getPrice() {
		return price;
	}

	public String getDate() {
		return date;
	}

	public String getStatus() {
		return status;
	}

	public List<OrdersDetailVo> getOrdersDetailList() {
		return ordersDetailList;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}

	public void setOrdersCode(String ordersCode) {
		this.ordersCode = ordersCode;
	}

	public void setOrdersName(String ordersName) {
		this.ordersName = ordersName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setOrdersDetailList(List<OrdersDetailVo> ordersDetailList) {
		this.ordersDetailList = ordersDetailList;
	}

	
	
	
	
}
