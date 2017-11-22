package controller;

import dbManager.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.DateHandler;
import model.Subscription;

public class SubscriptionQueries {

    public static Subscription getSubscription(int patientID, String planName) {

        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        Subscription subscription = null;
        try {
            pstmt = con.prepareStatement(
                "SELECT * FROM Subscription WHERE patientID = ? AND planName = ?");
            pstmt.setInt(1, patientID);
            pstmt.setString(2, planName);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                subscription = new Subscription(patientID,
                    planName,
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

    public static ArrayList<Subscription> getAllSubscriptions() {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        ArrayList<Subscription> subscriptions = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM Subscription");
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                subscriptions.add(new Subscription(res.getInt(1),
                    res.getString(2),
                    res.getDate(3),
                    res.getDate(4),
                    res.getInt(5),
                    res.getInt(6),
                    res.getInt(7)));
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

        return subscriptions;
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

    public static void deleteSubscription(int patientID, String planName) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con
                .prepareStatement("DELETE FROM Subscription WHERE patientID = ? AND planName = ?");
            pstmt.setInt(1, patientID);
            pstmt.setString(2, planName);
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

    public static void updateSubscription(int patientID, String planName,
        Subscription subscription) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(
                "UPDATE Subscription SET patientID = ?, planName = ?, startDate = ?, endDate = ?, checkUpLeft = ?, hygieneVisitLeft = ?, repairWorkLeft = ? WHERE patientID = ? AND planName = ?");
            pstmt.setInt(1, subscription.getPatientID());
            pstmt.setString(2, subscription.getPlanName());
            pstmt.setDate(3, subscription.getStartDate());
            pstmt.setDate(4, subscription.getEndDate());
            pstmt.setInt(5, subscription.getCheckUpLeft());
            pstmt.setInt(6, subscription.getHygieneVisitLeft());
            pstmt.setInt(7, subscription.getRepairWorkLeft());
            pstmt.setInt(8, patientID);
            pstmt.setString(9, planName);
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

        Subscription newSubscription = new Subscription(0, "NHS Free Plan",
            DateHandler.newDate(2017, 11, 18), DateHandler.newDate(2018, 11, 18), 2, 2, 6);
        SubscriptionQueries.insertSubscription(newSubscription);

        Subscription subscription = SubscriptionQueries.getSubscription(0, "NHS Free Plan");
        System.out.println(subscription);

        System.out.println(SubscriptionQueries.getAllSubscriptions());

        Subscription updatedSubscription = new Subscription(0, "Maintenance Plan",
            DateHandler.newDate(2017, 11, 18), DateHandler.newDate(2018, 11, 18), 2, 2, 0);
        SubscriptionQueries.updateSubscription(0, "NHS Free Plan", updatedSubscription);

        System.out.println(SubscriptionQueries.getAllSubscriptions());

        SubscriptionQueries.deleteSubscription(0, "Maintenance Plan");

        System.out.println(SubscriptionQueries.getAllSubscriptions());

    }

}
