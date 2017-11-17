package model;

import java.sql.Time;
import java.util.Date;

public class Appointment {

    private Date date;
    private Time startTime;
    private String partner;
    private int patientID;

    /**
     * Constructor for Appointment
     *
     * @param date The date
     * @param startTime The start time
     * @param partner The partner, dentist or hygienist
     * @param patientID The ID of the patient
     */
    public Appointment(Date date, Time startTime, String partner, int patientID) {
        this.date = date;
        this.startTime = startTime;
        this.partner = partner;
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
     * Get the partner of a appointment
     *
     * @return The partner of a appointment
     */
    public String getPartner() {
        return this.partner;
    }

    /**
     * Set the partner for a appointment
     *
     * @param partnerID The partner for a appointment
     */
    public void setPartner(int partnerID) {
        this.partner = partner;
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
}
