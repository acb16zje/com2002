package model;

import java.util.Date;

public class Patient {
	private String title;
	private String surName;
	private String foreName;
	private int phone;
	private Date dateOfBirth;
	private String houseNo;
	private String postcode;
	
	public Patient(String title, String surName, String foreName, int phone, Date dateOfBirth, String houseNo, String postcode) {
		this.title = title;
		this.surName = surName;
		this.foreName = foreName;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
		this.houseNo = houseNo;
		this.postcode = postcode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getForeName() {
		return foreName;
	}

	public void setForeName(String foreName) {
		this.foreName = foreName;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public String getFullName() {
		return title+" "+foreName+" "+surName;
	}
}
