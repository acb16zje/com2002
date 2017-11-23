package controller;

import dbManager.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Subscription;

public class SubscriptionQueries {

    public static Subscription getSubscription(int patientID) {

        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        Subscription subscription = null;
        try {
            pstmt = con.prepareStatement(
                "SELECT * FROM Subscription WHERE patientID = ?");
            pstmt.setInt(1, patientID);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                subscription = new Subscription(patientID,
                    res.getString(2),
                    res.getDate(3),
                    res.getDate(4),
                    res.getInt(5),
                    res.getInt(6),
                    res.getInt(7));
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

        return subscription;
    }

    public static void insertSubscription(Subscription subscription) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement("INSERT INTO Subscription VALUES (?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, subscription.getPatientID());
            pstmt.setString(2, subscription.getPlanName());
            pstmt.setDate(3, subscription.getStartDate());
            pstmt.setDate(4, subscription.getEndDate());
            pstmt.setInt(5, subscription.getCheckUpLeft());
            pstmt.setInt(6, subscription.getHygieneVisitLeft());
            pstmt.setInt(7, subscription.getRepairWorkLeft());
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

    public static void deleteSubscription(int patientID) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con
                .prepareStatement("DELETE FROM Subscription WHERE patientID = ?");
            pstmt.setInt(1, patientID);
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

    public static void updateSubscription(Subscription subscription) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement("SET foreign_key_checks = 0");
            pstmt.executeQuery();
            pstmt = con.prepareStatement(
                "UPDATE Subscription SET planName = ?, startDate = ?, endDate = ?, checkUpLeft = ?, hygieneVisitLeft = ?, repairWorkLeft = ? WHERE patientID = ?");
            pstmt.setString(1, subscription.getPlanName());
            pstmt.setDate(2, subscription.getStartDate());
            pstmt.setDate(3, subscription.getEndDate());
            pstmt.setInt(4, subscription.getCheckUpLeft());
            pstmt.setInt(5, subscription.getHygieneVisitLeft());
            pstmt.setInt(6, subscription.getRepairWorkLeft());
            pstmt.setInt(7, subscription.getPatientID());
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("SET foreign_key_checks = 1");
            pstmt.executeQuery();
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
}
