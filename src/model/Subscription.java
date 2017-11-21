package model;

import java.sql.Date;

public class Subscription {

    private int patientID;
    private String planName;
    private Date startDate;
    private Date endDate;
    private int checkUpLeft;
    private int hygieneVisitLeft;
    private int repairWorkLeft;

    /**
     * Constructr for Subscription
     *
     * @param patientID The ID of the patient
     * @param planName The name of the healthcare plan
     * @param startDate The start date of the subscription
     * @param endDate The end date of the subscription
     * @param checkUpLeft The check up left in the subscription
     * @param hygieneVisitLeft The hygiene visit left in the subscription
     * @param repairWorkLeft The repair work left in the subscription
     */
    public Subscription(int patientID, String planName, Date startDate, Date endDate,
        int checkUpLeft,
        int hygieneVisitLeft, int repairWorkLeft) {
        this.patientID = patientID;
        this.planName = planName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.checkUpLeft = checkUpLeft;
        this.hygieneVisitLeft = hygieneVisitLeft;
        this.repairWorkLeft = repairWorkLeft;
    }

    /**
     * Get the patient ID of the subscription
     *
     * @return The patient ID of the subscription
     */
    public int getPatientID() {
        return patientID;
    }

    /**
     * Set the patient ID for the subscription
     *
     * @param patientID The patient ID for the subscription
     */
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    /**
     * Get the name of the healthcare plan of the subscription
     *
     * @return The name of the healthcare plan of the subscription
     */
    public String getPlanName() {
        return planName;
    }

    /**
     * Set the name of the healthcare plan for the subscription
     *
     * @param planName The name of the healthcare plan for the subscription
     */
    public void setPlanName(String planName) {
        this.planName = planName;
    }

    /**
     * Get the start date of the subscription
     *
     * @return The start date of the subscription
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Set the start date for the subscription
     *
     * @param startDate The start date for the subscription
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Get the end date of the subscription
     *
     * @return The end date of the subscription
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Set the end date of the subscription
     *
     * @param endDate The end date of the subscription
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Get the amount of check up left in the subscription
     *
     * @return The amount of check up left in the subscription
     */
    public int getCheckUpLeft() {
        return checkUpLeft;
    }

    /**
     * Set the amount of check up left in the subscription
     *
     * @param checkUpLeft The amount of check up left in the subscription
     */
    public void setCheckUpLeft(int checkUpLeft) {
        this.checkUpLeft = checkUpLeft;
    }

    /**
     * Get the amount of hygiene visit left in the subscription
     *
     * @return The amount of hygiene visit left in the subscription
     */
    public int getHygieneVisitLeft() {
        return hygieneVisitLeft;
    }

    /**
     * Set the amount of hygiene visit left in the subscription
     *
     * @param hygieneVisitLeft The amount of hygiene vist left in the subscription
     */
    public void setHygieneVisitLeft(int hygieneVisitLeft) {
        this.hygieneVisitLeft = hygieneVisitLeft;
    }

    /**
     * Get the amount of repair work left in the subscription
     *
     * @return The amount of repair work left in the subscription
     */
    public int getRepairWorkLeft() {
        return repairWorkLeft;
    }

    /**
     * Set the amount of repair work left in the subscription
     *
     * @param repairWorkLeft The amount of repair work left in the subscription
     */
    public void setRepairWorkLeft(int repairWorkLeft) {
        this.repairWorkLeft = repairWorkLeft;
    }

    @Override
    public String toString() {
        return "Subscription [patientID=" + patientID + ", name=" + planName + ", startDate="
            + startDate + ", endDate="
            + endDate + ", checkUpsLeft=" + checkUpLeft + ", hygieneVisitsLeft="
            + hygieneVisitLeft
            + ", repairWorksLeft=" + repairWorkLeft + "]";
    }

}
