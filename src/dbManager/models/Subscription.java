package dbManager.models;

import java.sql.Date;

public class Subscription {

	private int patientID;
	private String name;
	private Date startDate;
	private Date endDate;
	private int checkUpsLeft;
	private int hygieneVisitsLeft;
	private int repairWorksLeft;
	
	public Subscription(int patientID, String name, Date startDate, Date endDate, int checkUpsLeft,
			int hygieneVisitsLeft, int repairWorksLeft) {
		this.patientID = patientID;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.checkUpsLeft = checkUpsLeft;
		this.hygieneVisitsLeft = hygieneVisitsLeft;
		this.repairWorksLeft = repairWorksLeft;
	}
	
	public int getPatientID() {
		return patientID;
	}
	
	public String getName() {
		return name;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public int getCheckUpsLeft() {
		return checkUpsLeft;
	}
	
	public int getHygieneVisitsLeft() {
		return hygieneVisitsLeft;
	}
	
	public int getRepairWorksLeft() {
		return repairWorksLeft;
	}

	@Override
	public String toString() {
		return "Subscription [patientID=" + patientID + ", name=" + name + ", startDate=" + startDate + ", endDate="
				+ endDate + ", checkUpsLeft=" + checkUpsLeft + ", hygieneVisitsLeft=" + hygieneVisitsLeft
				+ ", repairWorksLeft=" + repairWorksLeft + "]";
	}
	
	
	
}
