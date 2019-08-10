package com.cafe24.shope24.vo;

public class ProductVo {
	private Long no;
	private String name;
	private Long stock;
	private Long activeStock;
	private Long price;
	private String option;
	private String status;
	private Long displayProductNo;
	
	public Long getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public Long getStock() {
		return stock;
	}
	public Long getActiveStock() {
		return activeStock;
	}
	public Long getPrice() {
		return price;
	}
	public String getOption() {
		return option;
	}
	public String getStatus() {
		return status;
	}
	public Long getDisplayProductNo() {
		return displayProductNo;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setStock(Long stock) {
		this.stock = stock;
	}
	public void setActiveStock(Long activeStock) {
		this.activeStock = activeStock;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setDisplayProductNo(Long displayProductNo) {
		this.displayProductNo = displayProductNo;
	}
	@Override
	public String toString() {
		return "ProductVo [no=" + no + ", name=" + name + ", stock=" + stock + ", activeStock=" + activeStock
				+ ", price=" + price + ", option=" + option + ", status=" + status + ", displayProductNo="
				+ displayProductNo + "]";
	}
	
	
}
