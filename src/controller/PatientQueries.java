package controller;

import dbManager.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DateHandler;
import model.Patient;

public class PatientQueries {

    public static Patient getByID(int ID) {

        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        Patient patient = null;
        try {
            pstmt = con.prepareStatement("SELECT * FROM Patient WHERE patientID = ?");
            pstmt.setInt(1, ID);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                patient = new Patient(ID,
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getDate(5),
                    res.getString(6),
                    res.getString(7),
                    res.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            db.closeConnection();
        }

        return patient;

    }

    public static ArrayList<Patient> getAllPatients() {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        ArrayList<Patient> patients = new ArrayList<Patient>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM Patient");
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                patients.add(new Patient(res.getInt(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getDate(5),
                    res.getString(6),
                    res.getString(7),
                    res.getString(8)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            db.closeConnection();
        }

        return patients;
    }

    public static void insertPatient(Patient patient) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement("INSERT INTO Patient VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            PreparedStatement getID = con
                .prepareStatement("SELECT MAX(patientID) + 1 FROM Patient");
            ResultSet res = getID.executeQuery();
            res.next();
            int ID = res.getInt(1);
            getID.close();
            pstmt.setInt(1, ID);
            pstmt.setString(2, patient.getTitle());
            pstmt.setString(3, patient.getForename());
            pstmt.setString(4, patient.getSurname());
            pstmt.setDate(5, patient.getDateOfBirth());
            pstmt.setString(6, patient.getPhone());
            pstmt.setString(7, patient.getHouseNumber());
            pstmt.setString(8, patient.getPostCode());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            db.closeConnection();
        }
    }

    public static void deletePatient(int ID) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        Patient patient = null;
        try {
            pstmt = con.prepareStatement("DELETE FROM Patient WHERE patientID = ?");
            pstmt.setInt(1, ID);
            pstmt.executeUpdate();
            pstmt = con.prepareStatement(
                "UPDATE Patient SET patientID = patientID - 1 WHERE patientID > ?");
            pstmt.setInt(1, ID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            db.closeConnection();
        }
    }

    public static void updatePatient(Patient patient) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(
                "UPDATE Patient SET title = ?, forename = ?, surname = ?, dateOfBirth = ?, phone = ?, houseNumber = ?, postCode = ? WHERE patientID = ?");
            pstmt.setString(1, patient.getTitle());
            pstmt.setString(2, patient.getForename());
            pstmt.setString(3, patient.getSurname());
            pstmt.setDate(4, patient.getDateOfBirth());
            pstmt.setString(5, patient.getPhone());
            pstmt.setString(6, patient.getHouseNumber());
            pstmt.setString(7, patient.getPostCode());
            pstmt.setInt(8, patient.getPatientID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            db.closeConnection();
        }
    }

    public static void main(String[] args) {
        Patient patient = PatientQueries.getByID(0);
        System.out.println(patient);

        ArrayList<Patient> patients = PatientQueries.getAllPatients();
        System.out.println(patients);

        Patient newPatient = new Patient(0, "Mr", "Curly", "Boi", DateHandler.newDate(1969, 07, 06),
            "0783649208", "-", "-");
        PatientQueries.insertPatient(newPatient);

        patients = PatientQueries.getAllPatients();
        System.out.println(patients);

        Patient updatedPatient = new Patient(1, "Mrs", "Curly", "Lass",
            DateHandler.newDate(1969, 07, 06), "0783649208", "-", "-");
        PatientQueries.updatePatient(updatedPatient);

        patients = PatientQueries.getAllPatients();
        System.out.println(patients);

        PatientQueries.deletePatient(1);

        patients = PatientQueries.getAllPatients();
        System.out.println(patients);
    }

}
