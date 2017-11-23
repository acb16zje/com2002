package controller;

import dbManager.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.HealthCarePlan;

public class HealthCarePlanQueries {

    public static HealthCarePlan getPlan(String planName) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        HealthCarePlan plan = null;
        try {
            pstmt = con.prepareStatement("SELECT * FROM HealthCarePlan WHERE planName = ?");
            pstmt.setString(1, planName);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                plan = new HealthCarePlan(planName,
                    res.getInt(2),
                    res.getInt(3),
                    res.getInt(4),
                    res.getInt(5));
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

        return plan;

    }

    /**
     * Return all the plan names in database, used in JComboBox in PatientEditor
     *
     * @return Array of plan names
     */
    public static ArrayList getAllPlanName() {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        ArrayList<String> planName = new ArrayList<>();
        planName.add("");

        try {
            pstmt = con.prepareStatement("SELECT planName FROM HealthCarePlan");
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                planName.add(res.getString(1));
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

        return planName;
    }

    public static int getMonthlyFee(String planName) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement("SELECT monthlyFee FROM HealthCarePlan WHERE planName = ?");
            pstmt.setString(1, planName);
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

        return 0;
    }
}
