package dbManager.queries;

import dbManager.Database;
import dbManager.models.Record;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;

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
            pstmt = con.prepareStatement("SELECT * FROM Record WHERE treatmentGiven = ?, startTime = ?, date = ?, partnerID = ?");
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

    public static void main

}
