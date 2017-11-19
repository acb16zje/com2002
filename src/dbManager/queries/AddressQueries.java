package dbManager.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbManager.Database;
import dbManager.models.Address;

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
	
	public static void main(String[] args)	{
		
		Address blankAddress = AddressQueries.getAddress("-", "-");
		System.out.println(blankAddress);
		
	}
	
}
