package dbManager.queries;

import dbManager.Database;
import dbManager.models.DateHandler;
import dbManager.models.Record;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;

/**
 * @author Jake Sturgeon
 * @version 1.0 on 19/11/2017
 */
public class RecordQueries {

    public static Record getByRecord(String treatmentGiven, Time startTime, Date date, int partnerID) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        Record record = null;
        try {
            pstmt = con.prepareStatement("SELECT * FROM Record WHERE treatmentGiven = ? AND startTime = ? AND date = ? AND partnerID = ?");
            pstmt.setString(1, treatmentGiven);
            pstmt.setTime(2, startTime);
            pstmt.setDate(3, date);
            pstmt.setInt(4, partnerID);
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
            db.closeConnection();
        }

        return record;

    }

    public static void insertRecord(Record record) {
        Database db = new Database();
        Connection con = db.getCon();
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
            db.closeConnection();
        }
    }

    public static void deleteRecord(Record record) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement("DELETE FROM Record WHERE treatmentGiven = ? AND startTime = ? AND date = ? AND partnerID = ?");
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
            db.closeConnection();
        }

        return records;
    }

    public static void main(String[] args) {
        Record r = new Record("Check Up", Time.valueOf("12:00:00"), DateHandler
            .newDate(2017, 12, 25),0);
        System.out.println(RecordQueries.getByRecord("Check Up", Time.valueOf("12:00:00"), DateHandler
            .newDate(2017, 12, 25),0));

        RecordQueries.updateRecord(r,r);

        System.out.println(RecordQueries.getAllRecords());
    }

}
