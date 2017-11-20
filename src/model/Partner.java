package model;

public class Partner {

    private int ID;
    private String forename;
    private String surname;

    public Partner(int ID, String forename, String surname) {
        this.ID = ID;
        this.forename = forename;
        this.surname = surname;
    }

    public int getID() {
        return ID;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Partner{" +
            "ID=" + ID +
            ", forename='" + forename + '\'' +
            ", surname='" + surname + '\'' +
            '}';
    }
}
