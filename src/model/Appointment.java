package model;

import java.sql.Date;
import java.sql.Time;

public class Appointment {

    private Date date;
    private Time startTime;
    private Time endTime;
    private int partnerID;
    private int patientID;

    /**
     * Constructor for Appointment
     *
     * @param date The date
     * @param startTime The start time
     * @param partnerID The partner, dentist or hygienist
     * @param patientID The ID of the patient
     */
    public Appointment(Date date, Time startTime,Time endTime, int patientID, int partnerID) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.partnerID = partnerID;
        this.patientID = patientID;
    }

    /**
     * Get the date of the appointment
     *
     * @return The date of the appointment
     */
    public Date getDate() {
        return date;
    }

	/**
     * Set the date of the appointment
     *
     * @param date The new date appointment
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Get the start time of the appointment
     *
     * @return The start time of the appointment
     */
    public Time getStartTime() {
        return startTime;
    }

    /**
     * Set the start time of the appointment
     *
     * @param startTime The start time of a appointment
     */
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }
    
    /**
     * Get the end time of the appointment
     *
     * @return The end time of the appointment
     */
    public Time getEndTime() {
		return endTime;
	}
    
    /**
     * Set the end time of the appointment
     *
     * @param endTime The end time of a appointment
     */
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

    /**
     * Get the partner of a appointment
     *
     * @return The partner of a appointment
     */
    public int getPartnerID() {
        return this.partnerID;
    }

    /**
     * Set the partner for a appointment
     *
     * @param partnerID The partner for a appointment
     */
    public void setPartnerID(int partnerID) {
        this.partnerID = partnerID;
    }

    /**
     * Get the patient ID of a appointment
     *
     * @return The patient ID of a appointment
     */
    public int getPatientID() {
        return patientID;
    }

    /**
     * Set the patient ID for a appointment
     *
     * @param patientID The patient ID for a appointment
     */
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    @Override
    public String toString() {
        return "Appointment{" +
            "date=" + date +
            ", partnerID=" + partnerID +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            ", patientID=" + patientID +
            '}';
    }
}
