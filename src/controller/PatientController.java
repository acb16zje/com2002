package controller;

import java.util.Date;

import javax.swing.JFrame;

import model.Patient;

public class PatientController {
	private Patient model;
	private JFrame view;
	
	public PatientController(Patient model, JFrame view) {
		this.model = model;
		this.view = view;
	}
	
	public String getPatientName() {
		return model.getFullName();
	}
	
	public String getSurName() {
		return model.getSurName();
	}
	
	public String getForeName() {
		return model.getForeName();
	}
	
	public Date getDateOfBirth() {
		return model.getDateOfBirth();
	}
	
	public int getPhone() {
		return model.getPhone();
	}
	
	public String getPostCode() {
		return model.getPostcode();
	}
	
	public String getHouseNumber() {
		return model.getHouseNo();
	}
	
}
