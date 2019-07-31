package com.cafe24.shope24.vo;

public class FileVo {
	private Long no;
	private Long displayProductNo;
	private String oriName;
	private String changeName;
	private String url;
	private String status;
	private String date;
	public Long getNo() {
		return no;
	}
	public Long getDisplayProductNo() {
		return displayProductNo;
	}
	public String getOriName() {
		return oriName;
	}
	public String getChangeName() {
		return changeName;
	}
	public String getUrl() {
		return url;
	}
	public String getStatus() {
		return status;
	}
	public String getDate() {
		return date;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public void setDisplayProductNo(Long displayProductNo) {
		this.displayProductNo = displayProductNo;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "FileVo [no=" + no + ", displayProductNo=" + displayProductNo + ", oriName=" + oriName + ", changeName="
				+ changeName + ", url=" + url + ", status=" + status + ", date=" + date + "]";
	}
	
	
}
