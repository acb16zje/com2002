package controller;

import static java.time.temporal.ChronoUnit.MINUTES;

import dbManager.Database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Appointment;

/**
 * @author Jake Sturgeon
 * @version 1.0 on 18/11/2017
 */
public class AppointmentQueries {

    public static Appointment getAppointment(Date d, int partnerID, int patientID, Time time) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        Appointment appointment = null;
        try {
            pstmt = con.prepareStatement(
                "SELECT * FROM Appointment WHERE date = ? AND partnerID = ? AND patientID = ? AND startTime = ?");
            pstmt.setDate(1, d);
            pstmt.setInt(2, partnerID);
            pstmt.setInt(3, patientID);
            pstmt.setTime(4, time);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                appointment = new Appointment(d, time, res.getTime(3), res.getInt(4), partnerID);
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

    public static void getDayAppointmentList(JTable appointmentTable, java.util.Date date,
        int partnerID, int cols) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        DefaultTableModel model = (DefaultTableModel) appointmentTable.getModel();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        try {
            pstmt = con.prepareStatement(
                "SELECT startTime, endTime, patientID FROM Appointment WHERE date = ? AND partnerID = ?");
            pstmt.setDate(1, sqlDate);
            pstmt.setInt(2, partnerID);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                LocalTime startTime = res.getTime(1).toLocalTime();
                LocalTime endTime = res.getTime(2).toLocalTime();
                int cellsTaken = ((int) MINUTES.between(startTime, endTime)) / 20;
                int startCell =
                    ((int) MINUTES.between(LocalTime.parse("09:00:00"), startTime)) / 20;
                //Patient tempPatient = PatientQueries.getByID(res.getInt(3)); // Performance loss
                for (int i = startCell; i < cellsTaken + startCell; i++) {
                    if (res.getInt(3) == 0) {
                        model.setValueAt(0 + " " + startTime + " HOLIDAY", i, cols);
                    } else {
                        model.setValueAt(
                            res.getInt(3) + " " + startTime + " ", i,
                            cols);
                    }
                }
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
    }

    //returns a boolean list that represents time avaibility
    public static Boolean[] getAvailableTime(java.util.Date date, int partnerID) {
        Boolean[] avaibilityBoolean = new Boolean[24];
        Arrays.fill(avaibilityBoolean, true);
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        try {
            pstmt = con.prepareStatement(
                "SELECT startTime,endTime FROM Appointment WHERE date = ? AND partnerID = ?");
            pstmt.setDate(1, sqlDate);
            pstmt.setInt(2, partnerID);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                LocalTime startTime = res.getTime(1).toLocalTime();
                LocalTime endTime = res.getTime(2).toLocalTime();
                int cellsTaken = ((int) MINUTES.between(startTime, endTime)) / 20;
                int startCell =
                    ((int) MINUTES.between(LocalTime.parse("09:00:00"), startTime)) / 20;
                for (int i = startCell; i < cellsTaken + startCell; i++) {
                    avaibilityBoolean[i] = false;
                }
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
        return avaibilityBoolean;
    }

    //checks if time is valid for partner
    public static Boolean validTime(Time startTime, Time endTime, java.util.Date date,
        int partnerID) {
        Boolean[] avaibilityList = getAvailableTime(date, partnerID);
        LocalTime start = startTime.toLocalTime();
        LocalTime end = endTime.toLocalTime();
        int cellsTaken = ((int) MINUTES.between(start, end)) / 20;
        int startCell = ((int) MINUTES.between(LocalTime.parse("09:00:00"), start)) / 20;
        for (int i = startCell; i < cellsTaken + startCell; i++) {
            if (!avaibilityList[i]) {
                return false;
            }
        }
        return true;
    }

    //check if time is valid for patient
    public static Boolean validPatientTime(Time startTime, Time endTime, java.util.Date date,
        int patientID, int partnerID) {
        Boolean[] selectedList = new Boolean[24];
        Arrays.fill(selectedList, false);
        int tempID;
        LocalTime start = startTime.toLocalTime();
        LocalTime end = endTime.toLocalTime();
        int cellsTaken = ((int) MINUTES.between(start, end)) / 20;
        int startCell = ((int) MINUTES.between(LocalTime.parse("09:00:00"), start)) / 20;
        for (int i = startCell; i < cellsTaken + startCell; i++) {
            selectedList[i] = true;
        }
        if (partnerID == 0) {
            tempID = 1;
        } else {
            tempID = 0;
        }
        Calendar tempCal = Calendar.getInstance();
        tempCal.setTime(date);
        tempCal.set(Calendar.HOUR_OF_DAY, 9);
        tempCal.set(Calendar.MINUTE, 0);
        tempCal.set(Calendar.SECOND, 0);
        for (int i = 0; i < cellsTaken + startCell; i++) {
            Appointment tempApp = getAppointment(new java.sql.Date(date.getTime()), tempID,
                patientID, new java.sql.Time(tempCal.getTime().getTime()));
            if (tempApp != null) {
                LocalTime appointmentStart = tempApp.getStartTime().toLocalTime();
                LocalTime appointmentEnd = tempApp.getEndTime().toLocalTime();
                int appCellsTaken = ((int) MINUTES.between(appointmentStart, appointmentEnd)) / 20;
                int appStartCell =
                    ((int) MINUTES.between(LocalTime.parse("09:00:00"), appointmentStart)) / 20;
                for (int j = appStartCell; j < appCellsTaken + appStartCell; j++) {
                    if (selectedList[j]) {
                        return false;
                    }
                }

            }
            tempCal.add(Calendar.MINUTE, 20);
        }
        return true;
    }

    public static boolean isAppointmentCompleted(Time startTime, Date date, int partnerID) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(
                "SELECT COUNT(1) FROM Record WHERE startTime = ? AND date = ? AND partnerID = ?");
            pstmt.setTime(1, startTime);
            pstmt.setDate(2, date);
            pstmt.setInt(3, partnerID);
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

        return true;
    }

    public static ArrayList<Appointment> getAllAppointments() {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        ArrayList<Appointment> appointments = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM Appointment");
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                appointments.add(new Appointment(res.getDate(1),
                    res.getTime(2),
                    res.getTime(3),
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

        return appointments;
    }

    public static void insertAppointment(Appointment appointment) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement("INSERT INTO Appointment VALUES (?, ?, ?, ?, ?)");
            pstmt.setDate(1, appointment.getDate());
            pstmt.setTime(2, appointment.getStartTime());
            pstmt.setTime(3, appointment.getEndTime());
            pstmt.setInt(4, appointment.getPatientID());
            pstmt.setInt(5, appointment.getPartnerID());
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
            pstmt = con.prepareStatement(
                "DELETE FROM Appointment WHERE date = ? AND partnerID = ? AND startTime = ?");
            pstmt.setDate(1, d);
            pstmt.setInt(2, partnerID);
            pstmt.setTime(3, time);
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
