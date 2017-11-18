package dbManager.models;

public class HealthCarePlan {

	private String name;
	private int monthlyFee;
	private int checkUps;
	private int hygieneVisits;
	private int repairWorks;

	public HealthCarePlan(String name, int monthlyFee, int checkUps, int hygieneVisits, int repairWorks) {
		this.name = name;
		this.monthlyFee = monthlyFee;
		this.checkUps = checkUps;
		this.hygieneVisits = hygieneVisits;
		this.repairWorks = repairWorks;
	}

	public String getName() {
		return name;
	}

	public int getMonthlyFee() {
		return monthlyFee;
	}

	public int getCheckUps() {
		return checkUps;
	}

	public int getHygieneVisits() {
		return hygieneVisits;
	}

	public int getRepairWorks() {
		return repairWorks;
	}
	
}
