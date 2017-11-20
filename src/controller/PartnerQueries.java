package controller;

import dbManager.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Partner;

/**
 * @author Jake Sturgeon
 * @version 1.0 on 19/11/2017
 */
public class PartnerQueries {

    public static Partner getByID(int ID) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        Partner partner = null;
        try {
            pstmt = con.prepareStatement("SELECT * FROM Partner WHERE partnerID = ?");
            pstmt.setInt(1, ID);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                partner = new Partner(ID,
                    res.getString(2),
                    res.getString(3));
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

        return partner;

    }

    public static void insertPartner(Partner partner) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement("INSERT INTO Partner VALUES (?, ?, ?)");
            PreparedStatement getID = con
                .prepareStatement("SELECT MAX(partnerID) + 1 FROM Partner");
            ResultSet res = getID.executeQuery();
            res.next();
            int ID = res.getInt(1);
            getID.close();
            pstmt.setInt(1, ID);
            pstmt.setString(2, partner.getForename());
            pstmt.setString(3, partner.getSurname());
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

    public static void updatePartner(Partner partner) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(
                "UPDATE Partner SET forename = ?, surname = ? WHERE partnerID = ?");
            pstmt.setInt(3, partner.getID());
            pstmt.setString(1, partner.getForename());
            pstmt.setString(2, partner.getSurname());
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

    public static void deletePartner(int ID) {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        Partner partner = null;
        try {
            pstmt = con.prepareStatement("DELETE FROM Partner WHERE partnerID = ?");
            pstmt.setInt(1, ID);
            pstmt.executeUpdate();
            pstmt = con.prepareStatement(
                "UPDATE Partner SET partnerID = partnerID - 1 WHERE partnerID > ?");
            pstmt.setInt(1, ID);
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

    public static ArrayList<Partner> getAllPartners() {
        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        ArrayList<Partner> partners = new ArrayList<Partner>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM Partner");
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                partners.add(new Partner(res.getInt(1),
                    res.getString(2),
                    res.getString(3)));
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

        return partners;
    }

    public static void main(String[] args) {
        System.out.println(PartnerQueries.getByID(0));

        PartnerQueries.insertPartner(new Partner(0, "Jake", "Sturgeon"));
        System.out.println(PartnerQueries.getByID(2));

        PartnerQueries.updatePartner(new Partner(2, "Jake", "is the best"));
        System.out.println(PartnerQueries.getByID(2));

        PartnerQueries.deletePartner(2);
        System.out.println(PartnerQueries.getAllPartners());

    }
}
