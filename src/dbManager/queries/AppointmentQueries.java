package dbManager.queries;

import dbManager.Database;
import dbManager.models.Appointment;
import dbManager.models.DateHandler;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

/**
 * @author Jake Sturgeon
 * @version 1.0 on 18/11/2017
 */
public class AppointmentQueries {

    public static Appointment getAppointment(Date d, int partnerID, Time time) {

        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        Appointment appointment = null;
        try {
            pstmt = con.prepareStatement("SELECT * FROM Appointment WHERE date = ? AND partnerID = ? AND startTime = ?");
            pstmt.setDate(1, d);
            pstmt.setInt(2, partnerID);
            pstmt.setTime(3, time);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                appointment = new Appointment(d,
                    partnerID,
                    time,
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

        return appointment;

    }

    public static ArrayList<Appointment> getAllAppointments() {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        ArrayList<Appointment> appointments = new ArrayList<Appointment>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM Appointment");
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                appointments.add(new Appointment(res.getDate(1),
                    res.getInt(2),
                    res.getTime(3),
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

        return appointments;
    }

    public static void insertAppointment(Appointment appointment) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement("INSERT INTO Appointment VALUES (?, ?, ?, ?)");
            pstmt.setDate(1, appointment.getDate());
            pstmt.setInt(2, appointment.getPartnerID());
            pstmt.setTime(3, appointment.getStartTime());
            pstmt.setInt(4, appointment.getPatientID());
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

    public static void deleteAppointment(Date d, int partnerID, Time time) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement("DELETE FROM Appointment WHERE date = ? AND partnerID = ? AND startTime = ?");
            pstmt.setDate(1, d);
            pstmt.setInt(1, partnerID);
            pstmt.setTime(1, time);
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

    public static void updatePatient(Appointment appointment) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(
                "UPDATE Patient SET patientID = ? WHERE date = ? AND partnerID = ? AND startTime = ?");
            pstmt.setInt(1, appointment.getPatientID());
            pstmt.setDate(2, appointment.getDate());
            pstmt.setInt(3, appointment.getPartnerID());
            pstmt.setTime(4, appointment.getStartTime());
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
        Appointment app = new Appointment(DateHandler.newDate(2000, 8, 27), 0, Time.valueOf("03:45:00"),0);
        System.out.println(app);

        System.out.println(AppointmentQueries.getAppointment(DateHandler.newDate(2017, 12,25), 0, Time.valueOf("12:00:00")));

    }

}
