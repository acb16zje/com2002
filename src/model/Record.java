package model;

import java.sql.Time;
import java.util.Date;

public class Record {
	private String treatmentGiven;
	private Time startTime;
	private Date date;
	private String partner;
	
	public Record(String treatmentGiven, Time startTime, Date date, String partner) {
		this.treatmentGiven = treatmentGiven;
		this.startTime = startTime;
		this.date = date;
		this.partner = partner;
	}
	
	public String getTreatmentGiven() {
		return treatmentGiven;
	}
	public void setTreatmentGiven(String treatmentGiven) {
		this.treatmentGiven = treatmentGiven;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	
	
}
