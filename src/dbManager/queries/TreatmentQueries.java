package dbManager.queries;

import dbManager.Database;
import dbManager.models.Treatment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Jake Sturgeon
 * @version 1.0 on 19/11/2017
 */
public class TreatmentQueries {

    public static Treatment getByName(String name) {

        Database db = new Database();
        Connection con = db.getCon();
        PreparedStatement pstmt = null;
        Treatment treatment = null;
        try {
            pstmt = con.prepareStatement("SELECT * FROM Treatment WHERE name = ?");
            pstmt.setString(1, name);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                treatment = new Treatment(name,
                    res.getInt(2));
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

        return treatment;

    }

    public static void main(String[] args) {
        System.out.println(TreatmentQueries.getByName("Check up"));
    }

}
