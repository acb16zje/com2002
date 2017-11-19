package dbManager.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbManager.Database;
import dbManager.models.Address;
import dbManager.models.Patient;

public class AddressQueries {

	public static Address getAddress(String houseNumber, String postCode)	{
		
		Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        Address address = null;
        try {
            pstmt = con.prepareStatement("SELECT * FROM Address WHERE houseNumber = ? AND postCode = ?");
            pstmt.setString(1, houseNumber);
            pstmt.setString(2, postCode);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                address = new Address(houseNumber,
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    postCode);
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

        return address;
		
	}
	
	public static ArrayList<Address> getAllAddresses()	{
		Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        ArrayList<Address> addresses = new ArrayList<Address>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM Address");
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                addresses.add(new Address(res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5)));
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

        return addresses;
	}
	
	public static void insertAddress(Address address)	{
		Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement("INSERT INTO Address VALUES (?, ?, ?, ?, ?)");
            pstmt.setString(1, address.getHouseNumber());
            pstmt.setString(2, address.getStreet());
            pstmt.setString(3, address.getDistrict());
            pstmt.setString(4, address.getCity());
            pstmt.setString(5, address.getPostCode());
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
	
	public static void updateAddress(String houseNumber, String postCode, Address address)	{
		Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(
                "UPDATE Address SET houseNumber = ?, street = ?, district = ?, city = ?, postCode = ? WHERE houseNumber = ? AND postCode = ?");
            pstmt.setString(1, address.getHouseNumber());
            pstmt.setString(2, address.getStreet());
            pstmt.setString(3, address.getDistrict());
            pstmt.setString(4, address.getCity());
            pstmt.setString(5, address.getPostCode());
            pstmt.setString(6, houseNumber);
            pstmt.setString(7, postCode);
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
	
	public static void deleteAddress(String houseNumber, String postCode)	{
		
		Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        Address address = null;
        try {
            pstmt = con.prepareStatement("DELETE FROM Address WHERE houseNumber = ? AND postCode = ?");
            pstmt.setString(1, houseNumber);
            pstmt.setString(2, postCode);
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
	
	public static void main(String[] args)	{
		
		Address blankAddress = AddressQueries.getAddress("-", "-");
		System.out.println(blankAddress);
		
		Address newAddress = new Address("1", "Main Street", "Central", "Citytown", "P0ST CDE");
		AddressQueries.insertAddress(newAddress);
		
		System.out.println(AddressQueries.getAllAddresses());
		
		Address updatedAddress = new Address("2", "Other Street", "West", "Towncity", "HELL0");
		AddressQueries.updateAddress("1", "P0ST CDE", updatedAddress);
		
		System.out.println(AddressQueries.getAllAddresses());
		
		AddressQueries.deleteAddress("2", "HELL0");
		
		System.out.println(AddressQueries.getAllAddresses());
		
	}
	
}
