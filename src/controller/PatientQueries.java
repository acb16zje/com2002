package controller;

import dbManager.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Patient;

public class PatientQueries {

    /**
     * Get the list of patients from Database
     *
     * @param patientTable The patients table
     */
    public static void getPatientList(JTable patientTable) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;

        try {
            pstmt = con.prepareStatement(
                "SELECT Patient.*, Subscription.planName FROM Patient LEFT JOIN Subscription ON Subscription.patientID = Patient.patientID");
            ResultSet res = pstmt.executeQuery();
            ((DefaultTableModel) patientTable.getModel()).setRowCount(0);
            while (res.next()) {
                ((DefaultTableModel) patientTable.getModel()).addRow(
                    new Object[]{
                        res.getInt(1),
                        res.getString(2),
                        res.getString(3) + " " + res.getString(4),
                        new SimpleDateFormat("dd-MM-yyyy").format(res.getDate(5)),
                        res.getString(6),
                        AddressQueries.getAddress(res.getString(7), res.getString(8)),
                        res.getString(9)
                    }
                );
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
    }

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
                    AddressQueries.getAddress(res.getString(7), res.getString(8)));
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

    public static String getNameByID(int ID) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con
                .prepareStatement("SELECT forename, surname FROM Patient WHERE patientID = ?");
            pstmt.setInt(1, ID);
            ResultSet res = pstmt.executeQuery();
            res.next();
            return res.getString(1) + " " + res.getString(2);
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

        return "";
    }

    public static void insertPatient(Patient patient) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement("INSERT INTO Patient VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, patient.getPatientID());
            pstmt.setString(2, patient.getTitle());
            pstmt.setString(3, patient.getForename());
            pstmt.setString(4, patient.getSurname());
            pstmt.setDate(5, patient.getDateOfBirth());
            pstmt.setString(6, patient.getPhone());
            pstmt.setString(7, patient.getAddress().getHouseNo());
            pstmt.setString(8, patient.getAddress().getPostcode());
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
            pstmt.setString(6, patient.getAddress().getHouseNo());
            pstmt.setString(7, patient.getAddress().getPostcode());
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

    public static int getNewPatientID() {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        int maxID = 0;
        try {
            pstmt = con.prepareStatement("SELECT MAX(patientID) + 1 FROM Patient");
            ResultSet res = pstmt.executeQuery();
            res.next();
            return res.getInt(1);
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

        return maxID;
    }
}
