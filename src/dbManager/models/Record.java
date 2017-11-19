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

    public Record(String treatmentGiven, Time startTime, Date date, int partnerID) {
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

	@Override
	public String toString() {
		return "Record [date=" + date + ", partnerID=" + partnerID + ", startTime=" + startTime + ", treatmentGiven="
				+ treatmentGiven + "]";
	}
    
    
    
}
