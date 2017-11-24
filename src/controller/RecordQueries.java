package controller;

import dbManager.Database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import model.Appointment;
import model.Record;

public class RecordQueries {

    public static Record getByRecord(Time startTime, Date date, int partnerID) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        Record record = null;
        try {
            pstmt = con.prepareStatement(
                "SELECT * FROM Record WHERE startTime = ? AND date = ? AND partnerID = ?");
            pstmt.setTime(1, startTime);
            pstmt.setDate(2, date);
            pstmt.setInt(3, partnerID);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                record = new Record(res.getString(1),
                    res.getTime(2),
                    res.getDate(3),
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

        return record;

    }

    public static void insertRecord(Record record) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement("INSERT INTO Record VALUES (?, ?, ?, ?, ?)");
            pstmt.setString(1, record.getTreatmentGiven());
            pstmt.setTime(2, record.getStartTime());
            pstmt.setDate(3, record.getDate());
            pstmt.setInt(4, record.getPartnerID());
            pstmt.setInt(5, record.getAmountOwed());
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

    public static boolean recordAlreadyExist(Appointment app) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con
                .prepareStatement("SELECT COUNT(3) FROM Record WHERE startTime = ? AND date = ?");
            pstmt.setTime(1, app.getStartTime());
            pstmt.setDate(2, app.getDate());
            ResultSet res = pstmt.executeQuery();
            res.next();
            return res.getInt(1) != 0;
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

        return false;
    }


    public static int getAmountOwedByName(String name, Appointment app) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(
                "SELECT amountOwed FROM Record WHERE treatmentGiven = ? AND startTime = ? AND date = ?");
            pstmt.setString(1, name);
            pstmt.setTime(2, app.getStartTime());
            pstmt.setDate(3, app.getDate());
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

    public static void deleteRecord(Record record) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(
                "DELETE FROM Record WHERE treatmentGiven = ? AND startTime = ? AND date = ? AND partnerID = ?");
            pstmt.setString(1, record.getTreatmentGiven());
            pstmt.setTime(2, record.getStartTime());
            pstmt.setDate(3, record.getDate());
            pstmt.setInt(4, record.getPartnerID());
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

    public static void updateRecord(Record oldTreatment, Record newTreatment) {
        RecordQueries.deleteRecord(oldTreatment);
        RecordQueries.insertRecord(newTreatment);
    }

    public static ArrayList<Record> getAllRecords() {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        ArrayList<Record> records = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM Record");
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                records.add(new Record(
                    res.getString(1),
                    res.getTime(2),
                    res.getDate(3),
                    res.getInt(4),
                    res.getInt(5))
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

        return records;
    }
}
