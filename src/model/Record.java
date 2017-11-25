package model;

import java.sql.Date;
import java.sql.Time;

public class Record {

    private String treatmentGiven;
    private Time startTime;
    private Date date;
    private int partnerID;
    private final int quantity;
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

    public Time getStartTime() {
        return startTime;
    }

    public Date getDate() {
        return date;
    }

    public int getPartnerID() {
        return partnerID;
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
