package dbManager.models;

import java.sql.Date;
import java.sql.Time;

/**
 * @author Jake Sturgeon
 * @version 1.0 on 18/11/2017
 */
public class Appointment {

    private Date date;
    private int partnerID;
    private Time startTime;
    private int patientID;

    public Appointment(Date date, Time startTime, int patientID, int partnerID) {
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

    @Override
    public String toString() {
        return "Appointment{" +
            "date=" + date +
            ", partnerID=" + partnerID +
            ", startTime=" + startTime +
            ", patientID=" + patientID +
            '}';
    }
}
