package com.green.example.entity;

public class Contact {
	private String name;
	private String photo;
	private String birthday;
	private String sex;
	private String address;
	private String phoneNumber;
	private String email;
	private String note;
	
	
	
	public Contact() {

	}
	public Contact(String name, String photo, String birthday, String sex, String address, String phoneNumber,
			String email, String note) {
		this.name = name;
		this.photo = photo;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.note = note;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
