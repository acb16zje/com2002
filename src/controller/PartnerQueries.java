package controller;

import dbManager.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Partner;

/**
 * @author Jake Sturgeon
 * @version 1.0 on 19/11/2017
 */
public class PartnerQueries {

    public static Partner getByID(int ID) {
        Connection con = Database.getConnection();
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

        }

        return partner;
    }
}
