package dbManager.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbManager.Database;
import dbManager.models.Patient;

public class PatientQueries {

	public static Patient getByID(int ID)	{
		
		Database db = new Database();
		Connection con = db.getCon();
		PreparedStatement pstmt = null;
		Patient patient = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM Patient WHERE patientID = ?");
			pstmt.setInt(1, ID);
			ResultSet res = pstmt.executeQuery();
			while(res.next())	{
				patient = new Patient(ID, 
									res.getString(2),
									res.getString(3), 
									res.getString(4), 
									res.getDate(5), 
									res.getString(6), 
									res.getString(7), 
									res.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			if (pstmt != null)	{
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			db.closeConnection();
		}
		
		return patient;
		
	}
	
	public static ArrayList<Patient> getAllPatients()	{
		Database db = new Database();
		Connection con = db.getCon();
		PreparedStatement pstmt = null;
		ArrayList<Patient> patients = new ArrayList<Patient>();
		try {
			pstmt = con.prepareStatement("SELECT * FROM Patient");
			ResultSet res = pstmt.executeQuery();
			while(res.next())	{
				patients.add(new Patient(res.getInt(1), 
									res.getString(2),
									res.getString(3), 
									res.getString(4), 
									res.getDate(5), 
									res.getString(6), 
									res.getString(7), 
									res.getString(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally	{
			if (pstmt != null)	{
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			db.closeConnection();
		}
		
		return patients;
	}
	
	public static void insertPatient(Patient patient)	{
		
	}

	public static void main(String[] args)	{
		Patient patient = PatientQueries.getByID(0);
		System.out.println(patient);
		
		ArrayList<Patient> patients = PatientQueries.getAllPatients();
		System.out.println(patients);
	}
	
}
