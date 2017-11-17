package model;

public class HealthcarePlan {

    private String planName;
    private int monthlyPayment;
    private int checkUp;
    private int hygieneVisit;
    private int repairWork;

    public HealthcarePlan(String planName, int monthlyPayment, int checkUp, int hygieneVisit,
        int repairWork) {
        this.planName = planName;
        this.monthlyPayment = monthlyPayment;
        this.checkUp = checkUp;
        this.hygieneVisit = hygieneVisit;
        this.repairWork = repairWork;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public int getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(int monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public int getCheckUp() {
        return checkUp;
    }

    public void setCheckUp(int checkUp) {
        this.checkUp = checkUp;
    }

    public int getHygieneVisit() {
        return hygieneVisit;
    }

    public void setHygieneVisit(int hygieneVisit) {
        this.hygieneVisit = hygieneVisit;
    }

    public int getRepairWork() {
        return repairWork;
    }

    public void setRepairWork(int repairWork) {
        this.repairWork = repairWork;
    }

}
