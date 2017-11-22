package model;

public class HealthCarePlan {

    private String planName;
    private int monthlyFee;
    private int checkUp;
    private int hygieneVisit;
    private int repairWork;

    public HealthCarePlan(String planName, int monthlyFee, int checkUp, int hygieneVisit,
        int repairWork) {
        this.planName = planName;
        this.monthlyFee = monthlyFee;
        this.checkUp = checkUp;
        this.hygieneVisit = hygieneVisit;
        this.repairWork = repairWork;
    }

    public String getPlanName() {
        return planName;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public int getCheckUp() {
        return checkUp;
    }

    public int getHygieneVisit() {
        return hygieneVisit;
    }

    public int getRepairWork() {
        return repairWork;
    }

    @Override
    public String toString() {
        return "HealthCarePlan [name=" + planName + ", monthlyFee=" + monthlyFee + ", checkUps="
            + checkUp
            + ", hygieneVisits=" + hygieneVisit + ", repairWorks=" + repairWork + "]";
    }

}
