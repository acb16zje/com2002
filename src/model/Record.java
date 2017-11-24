package model;

import java.sql.Date;
import java.sql.Time;

public class Record {

    private String treatmentGiven;
    private Time startTime;
    private Date date;
    private int partnerID;
    private int amountOwned;

    public Record(String treatmentGiven, Time startTime, Date date, int partnerID, int amountOwned) {
        this.treatmentGiven = treatmentGiven;
        this.startTime = startTime;
        this.date = date;
        this.partnerID = partnerID;
        this.amountOwned = amountOwned;
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

    public int getAmountOwned() {
        return amountOwned;
    }

    public void setAmountOwned(int amountOwned) {
        this.amountOwned = amountOwned;
    }

    @Override
    public String toString() {
        return "Record [date=" + date + ", partnerID=" + partnerID + ", startTime=" + startTime
            + ", treatmentGiven=" + treatmentGiven + "]";
    }
}
