package dbManager.models;

import java.sql.Date;

public class Patient {

    private int ID;
    private String title;
    private String forename;
    private String surname;
    private Date DOB;
    private String phone;
    private String houseNumber;
    private String postCode;

    public Patient(int ID, String title, String forename, String surname, Date DOB, String phone, String houseNumber, String postCode) {
        this.ID = ID;
        this.title = title;
        this.forename = forename;
        this.surname = surname;
        this.DOB = DOB;
        this.phone = phone;
        this.houseNumber = houseNumber;
        this.postCode = postCode;
    }

    public int getID() {
        return ID;
    }

    public String getTitle()	{
    	return title;
    }
    
    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    public Date getDOB() {
        return DOB;
    }

    public String getPhone() {
        return phone;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getPostCode() {
        return postCode;
    }

	@Override
	public String toString() {
		return "Patient [ID=" + ID + ", title=" + title + ", forename=" + forename + ", surname=" + surname + ", DOB="
				+ DOB + ", phone=" + phone + ", houseNumber=" + houseNumber + ", postCode=" + postCode + "]";
	}

    
    
}
