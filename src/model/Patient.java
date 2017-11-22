package model;

import java.sql.Date;

public class Patient {

    private int patientID;
    private String title;
    private String surname;
    private String forename;
    private String phone;
    private Date dateOfBirth;
    private Address address;

    /**
     * Constructor for patient
     *
     * @param patientID The ID of the patient
     * @param title The title of the patient
     * @param forename The forename of the patient
     * @param surname The surname of the patient
     * @param phone The phone number of the patient
     * @param dateOfBirth The date of birth of the patient
     * @param address The address of the patient
     */
    public Patient(int patientID, String title, String forename, String surname, Date dateOfBirth,
        String phone, Address address) {
        this.patientID = patientID;
        this.title = title;
        this.forename = forename;
        this.surname = surname;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    /**
     * Get the title of the patient
     *
     * @return The title of the patient
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title for the patient
     *
     * @param title The title for the patient
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the surname of the patient
     *
     * @return The surname of the patient
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Set the surname for the patient
     *
     * @param surname The surname for the patient
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Get the forename of the patient
     *
     * @return The forename of the patient
     */
    public String getForename() {
        return forename;
    }

    /**
     * Set the forename for the patient
     *
     * @param forename The forename for the patient
     */
    public void setForename(String forename) {
        this.forename = forename;
    }

    /**
     * Get the phone number of the patient
     *
     * @return The phone number of the patient
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the phone number for patient
     *
     * @param phone The phone number for the patient
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get the date of birth of the patient
     *
     * @return The date of birth of the patient
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Set the date of birth for the patient
     *
     * @param dateOfBirth The date of birth for the patient
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Get the address of the patient
     *
     * @return The address of the patient
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Get the ID of the patient
     *
     * @return The ID of the patient
     */
    public int getPatientID() {
        return patientID;
    }

    /**
     * Get the fullname with title of the patient
     *
     * @return The fullname with title of the patient
     */
    public String getFullName() {
        return title + " " + forename + " " + surname;
    }

    @Override
    public String toString() {
        return "Patient [ID=" + patientID + ", title=" + title + ", forename=" + forename
            + ", surname="
            + surname + ", DOB="
            + dateOfBirth + ", phone=" + phone + ", houseNumber=" + getAddress().getHouseNo()
            + ", postCode=" + getAddress().getPostcode()
            + "]";
    }
}
