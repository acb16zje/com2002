package controller;

import dbManager.Database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import model.Record;
import util.DateHandler;

/**
 * @author Jake Sturgeon
 * @version 1.0 on 19/11/2017
 */
public class RecordQueries {

    public static Record getByRecord(Time startTime, Date date, int partnerID) {
        Connection con = Database.getConnection();
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
                    res.getInt(4));
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

        }

        return record;

    }

    public static void insertRecord(Record record) {
        Connection con = Database.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement("INSERT INTO Record VALUES (?, ?, ?, ?)");
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

        }
    }

    public static void deleteRecord(Record record) {
        Connection con = Database.getConnection();
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

        }
    }

    public static void updateRecord(Record oldTreatment, Record newTreatment) {
        RecordQueries.deleteRecord(oldTreatment);
        RecordQueries.insertRecord(newTreatment);
    }

    public static ArrayList<Record> getAllRecords() {
        Connection con = Database.getConnection();
        PreparedStatement pstmt = null;
        ArrayList<Record> records = new ArrayList<Record>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM Record");
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                records.add(new Record(res.getString(1),
                    res.getTime(2),
                    res.getDate(3),
                    res.getInt(4)));
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

        }

        return records;
    }

    public static void main(String[] args) {
        Record r = new Record("Check Up", Time.valueOf("12:00:00"), DateHandler
            .newDate(2017, 12, 25), 0);
        System.out
            .println(RecordQueries.getByRecord(Time.valueOf("12:00:00"), DateHandler
                .newDate(2017, 12, 25), 0));

        RecordQueries.updateRecord(r, r);

        System.out.println(RecordQueries.getAllRecords());
    }

}
