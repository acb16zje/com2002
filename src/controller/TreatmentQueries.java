package controller;

import dbManager.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Treatment;

/**
 * @author Jake Sturgeon
 * @version 1.0 on 19/11/2017
 */
public class TreatmentQueries {

    public static Treatment getByName(String name) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        Treatment treatment = null;
        try {
            pstmt = con.prepareStatement("SELECT * FROM Treatment WHERE name = ?");
            pstmt.setString(1, name);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                treatment = new Treatment(name, res.getString(2), res.getInt(3));
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

        return treatment;

    }

    public static void insertTreatment(Treatment treatment) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement("INSERT INTO Treatment VALUES (?, ?)");
            pstmt.setString(1, treatment.getName());
            pstmt.setInt(2, treatment.getCost());
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

    public static void updateTreatment(Treatment treatment) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(
                "UPDATE Treatment SET cost = ? WHERE name = ?");
            pstmt.setInt(1, treatment.getCost());
            pstmt.setString(2, treatment.getName());
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

    public static void deleteTreatment(String name) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        Treatment treatment = null;
        try {
            pstmt = con.prepareStatement("DELETE FROM Treatment WHERE name = ?");
            pstmt.setString(1, name);
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


    public static ArrayList<Treatment> getAllTreatments() {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        ArrayList<Treatment> patients = new ArrayList<Treatment>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM Treatment");
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                patients.add(new Treatment(res.getString(1), res.getString(2), res.getInt(3)));
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

    public static void main(String[] args) {
        System.out.println(TreatmentQueries.getByName("Check up"));
        TreatmentQueries.insertTreatment(new Treatment("bant", "hygiene", 69));
        System.out.println(TreatmentQueries.getByName("bant"));
        TreatmentQueries.updateTreatment(new Treatment("bant", "repair", 169));
        System.out.println(TreatmentQueries.getByName("bant"));
        TreatmentQueries.deleteTreatment("bant");

        System.out.println(TreatmentQueries.getAllTreatments());

    }

}
