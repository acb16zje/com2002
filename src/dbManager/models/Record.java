package dbManager.models;

import java.sql.Time;
import java.util.Date;

/**
 * @author Jake Sturgeon
 * @version 1.0 on 18/11/2017
 */
public class Record {

    private Date date;
    private int partnerID;
    private Time startTime;
    private String treatmentGiven;

    public Record(Date date, int partnerID, Time startTime, String treatmentGiven) {
        this.date = date;
        this.partnerID = partnerID;
        this.startTime = startTime;
        this.treatmentGiven = treatmentGiven;
    }

    public Date getDate() {
        return date;
    }

    public int getPartnerID() {
        return partnerID;
    }

    public Time getStartTime() {
        return startTime;
    }

    public String getTreatmentGiven() {
        return treatmentGiven;
    }
}
