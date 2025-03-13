package com.learn.entity;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String name;
	private String phone;
	private String address;
	private String address_detail;
	private String member_status = "active";
	private String member_class;
	private String email;
	private Boolean marketing_agree;
	private String social_login;
	private Timestamp last_logged_at;
	private Date created_at;

	public Member() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getMember_status() {
		return member_status;
	}

	public void setMember_status(String member_status) {
		this.member_status = member_status;
	}

	public String getMember_class() {
		return member_class;
	}

	public void setMember_class(String member_class) {
		this.member_class = member_class;
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

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", address_detail="
				+ address_detail + ", member_status=" + member_status + ", member_class=" + member_class + ", email="
				+ email + ", marketing_agree=" + marketing_agree + ", social_login=" + social_login
				+ ", last_logged_at=" + last_logged_at + ", created_at=" + created_at + "]";
	}
}
