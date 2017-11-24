package model;

import java.sql.Date;
import java.sql.Time;

public class Record {

    private String treatmentGiven;
    private Time startTime;
    private Date date;
    private int partnerID;
    private int quantity;
    private int amountOwed;

    public Record(String treatmentGiven, Time startTime, Date date, int partnerID, int quantity,
        int amountOwed) {
        this.treatmentGiven = treatmentGiven;
        this.startTime = startTime;
        this.date = date;
        this.partnerID = partnerID;
        this.quantity = quantity;
        this.amountOwed = amountOwed;
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

    public int getPartnerID() {
        return partnerID;
    }

    public void setPartnerID(int partnerID) {
        this.partnerID = partnerID;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(int amountOwed) {
        this.amountOwed = amountOwed;
    }

    @Override
    public String toString() {
        return "Record [date=" + date + ", partnerID=" + partnerID + ", startTime=" + startTime
            + ", treatmentGiven=" + treatmentGiven + "]";
    }
}
