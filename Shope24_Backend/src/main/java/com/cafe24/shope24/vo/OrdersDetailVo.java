package com.cafe24.shope24.vo;

public class OrdersDetailVo {
	private Long no;
	private Long productNo;
	private Long ordersNo;
	private Long count;
	@Override
	public String toString() {
		return "OrdersDetailVo [no=" + no + ", productNo=" + productNo + ", ordersNo=" + ordersNo + ", count=" + count
				+ "]";
	}
	public Long getNo() {
		return no;
	}
	public Long getProductNo() {
		return productNo;
	}
	public Long getOrdersNo() {
		return ordersNo;
	}
	public Long getCount() {
		return count;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}
	public void setOrdersNo(Long ordersNo) {
		this.ordersNo = ordersNo;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	
	
}
