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

    public static void insertPlan(HealthCarePlan plan) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement("INSERT INTO HealthCarePlan VALUES (?, ?, ?, ?, ?)");
            pstmt.setString(1, plan.getPlanName());
            pstmt.setInt(2, plan.getMonthlyFee());
            pstmt.setInt(3, plan.getCheckUp());
            pstmt.setInt(4, plan.getHygieneVisit());
            pstmt.setInt(5, plan.getRepairWork());
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

    public static void deletePlan(String planName) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        HealthCarePlan plan = null;
        try {
            pstmt = con.prepareStatement("DELETE FROM HealthCarePlan WHERE planName = ?");
            pstmt.setString(1, planName);
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

    public static void updatePlan(HealthCarePlan plan) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(
                "UPDATE HealthCarePlan SET monthlyFee = ?, checkUp = ?, hygieneVisit = ?, repairWork = ? WHERE planName = ?");
            pstmt.setInt(1, plan.getMonthlyFee());
            pstmt.setInt(2, plan.getCheckUp());
            pstmt.setInt(3, plan.getHygieneVisit());
            pstmt.setInt(4, plan.getRepairWork());
            pstmt.setString(5, plan.getPlanName());
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
}
