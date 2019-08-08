package com.cafe24.shope24.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.cafe24.shope24.validator.constraints.ValidGender;
import com.cafe24.shope24.validator.constraints.ValidId;
import com.cafe24.shope24.validator.constraints.ValidPassword;

public class MemberVo {
	
	private Long no;
	
	private String id;
	
	private String password;
	
	private String name;
	
	private String email;
	
	private String status;
	private String phone;
	
	private String gender;
	private String birth;
	private String role;
	
	private String key;
	
	public String toString() {
		return "MemberVo [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", status=" + status + ", phone=" + phone + ", gender=" + gender + ", birth=" + birth + ", role="
				+ role + "]";
	}

	public Long getNo() {
		return no;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getStatus() {
		return status;
	}

	public String getPhone() {
		return phone;
	}

	public String getGender() {
		return gender;
	}

	public String getBirth() {
		return birth;
	}

	public String getRole() {
		return role;
	}

	public String getKey() {
		return key;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setKey(String key) {
		this.key = key;
	}

	
	
	
}
