package controller;

import dbManager.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Address;

public class AddressQueries {

    public static Address getAddress(String houseNumber, String postCode) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        Address address = null;
        try {
            pstmt = con
                .prepareStatement("SELECT * FROM Address WHERE houseNumber = ? AND postCode = ?");
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

    public static boolean isUniqueAddress(String houseNo, String postcode) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(
                "SELECT COUNT(*) FROM Address WHERE houseNumber = ? AND postCode = ?");
            pstmt.setString(1, houseNo);
            pstmt.setString(2, postcode);
            ResultSet res = pstmt.executeQuery();
            res.next();
            return res.getInt(1) == 0;
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

    public static void insertAddress(Address address) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement("INSERT INTO Address VALUES (?, ?, ?, ?, ?)");
            pstmt.setString(1, address.getHouseNo());
            pstmt.setString(2, address.getStreet());
            pstmt.setString(3, address.getDistrict());
            pstmt.setString(4, address.getCity());
            pstmt.setString(5, address.getPostcode());
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

    public static void updateAddress(String houseNumber, String postCode, Address address) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement("SET foreign_key_checks = 0");
            pstmt.executeQuery();
            pstmt = con.prepareStatement(
                "UPDATE Address SET houseNumber = ?, street = ?, district = ?, city = ?, postCode = ? WHERE houseNumber = ? AND postCode = ?");
            pstmt.setString(1, address.getHouseNo());
            pstmt.setString(2, address.getStreet());
            pstmt.setString(3, address.getDistrict());
            pstmt.setString(4, address.getCity());
            pstmt.setString(5, address.getPostcode());
            pstmt.setString(6, houseNumber);
            pstmt.setString(7, postCode);
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("SET foreign_key_checks = 1");
            pstmt.executeQuery();
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
