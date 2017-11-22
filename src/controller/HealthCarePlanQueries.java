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

    public static ArrayList<HealthCarePlan> getAllPlans() {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        ArrayList<HealthCarePlan> plans = new ArrayList<HealthCarePlan>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM HealthCarePlan");
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                plans.add(new HealthCarePlan(res.getString(1),
                    res.getInt(2),
                    res.getInt(3),
                    res.getInt(4),
                    res.getInt(5)));
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

        return plans;
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

    public static void main(String[] args) {

        HealthCarePlan plan = HealthCarePlanQueries.getPlan("NHS Free Plan");
        System.out.println(plan);

        HealthCarePlan newPlan = new HealthCarePlan("Test Plan", 69, 8, 7, 6);
        HealthCarePlanQueries.insertPlan(newPlan);

        System.out.println(HealthCarePlanQueries.getAllPlans());

        HealthCarePlan updatedPlan = new HealthCarePlan("Test Plan", 34, 1, 2, 3);
        HealthCarePlanQueries.updatePlan(updatedPlan);

        System.out.println(HealthCarePlanQueries.getAllPlans());

        HealthCarePlanQueries.deletePlan("Test Plan");

        System.out.println(HealthCarePlanQueries.getAllPlans());
    }

}
