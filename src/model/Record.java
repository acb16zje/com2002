package model;

import java.sql.Time;
import java.sql.Date;

public class Record {

    private String treatmentGiven;
    private Time startTime;
    private Date date;
    private int partnerID;

    public Record(String treatmentGiven, Time startTime, Date date, int partnerID) {
        this.treatmentGiven = treatmentGiven;
        this.startTime = startTime;
        this.date = date;
        this.partnerID = partnerID;
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

    @Override
    public String toString() {
        return "Record [date=" + date + ", partnerID=" + partnerID + ", startTime=" + startTime
            + ", treatmentGiven="
            + treatmentGiven + "]";
    }
}
