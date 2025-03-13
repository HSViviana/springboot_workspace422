package com.learn.entity;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// 1
@Entity
public class User {

	// 5
	@Id
	// 6
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// UUDI: 문자열, Sequence(다른 컬럼이 있을 때 사용): 호출시 1씩 증가, Identity: auto increment

	private Long id;
	
	@Column(nullable = false, length = 20)
	private String name;
	@Column(nullable = true, length = 13)
	private String phone;
	private String address;
	private String address_detail;
	private String user_status;
	private String user_class;
	private String email;
	private boolean marketing_agree;
	private String social_login;
	private Timestamp last_logged_at;
	private Date created_at;

	// 4. 기본 생성자
	public User() {
	}

	// 3. toString
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", address_detail="
				+ address_detail + ", user_status=" + user_status + ", user_class=" + user_class + ", email=" + email
				+ ", marketing_agree=" + marketing_agree + ", social_login=" + social_login + ", last_logged_at="
				+ last_logged_at + ", created_at=" + created_at + "]";
	}

	// 2. getter/setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress_detail() {
		return address_detail;
	}

	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}

	public String getUser_status() {
		return user_status;
	}

	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}

	public String getUser_class() {
		return user_class;
	}

	public void setUser_class(String user_class) {
		this.user_class = user_class;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isMarketing_agree() {
		return marketing_agree;
	}

	public void setMarketing_agree(boolean marketing_agree) {
		this.marketing_agree = marketing_agree;
	}

	public String getSocial_login() {
		return social_login;
	}

	public void setSocial_login(String social_login) {
		this.social_login = social_login;
	}

	public Timestamp getLast_logged_at() {
		return last_logged_at;
	}

	public void setLast_logged_at(Timestamp last_logged_at) {
		this.last_logged_at = last_logged_at;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
}
