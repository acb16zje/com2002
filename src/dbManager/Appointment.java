package dbManager;

import java.sql.Time;
import java.util.Date;

/**
 * @author Jake Sturgeon
 * @version 1.0 on 18/11/2017
 */
public class Appointment {

    private Date date;
    private int partnerID;
    private Time startTime;
    private int patientID;

    public Appointment(Date date, int partnerID, Time startTime, int patientID) {
        this.date = date;
        this.partnerID = partnerID;
        this.startTime = startTime;
        this.patientID = patientID;
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

    public int getPatientID() {
        return patientID;
    }
}
