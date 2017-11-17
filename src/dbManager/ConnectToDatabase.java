package dbManager;

import java.sql.*;

/**
 * @author Jake Sturgeon
 * @version 1.0 on 17/11/2017
 */
public class ConnectToDatabase {

    Connection con;  //Connect to db
    public ConnectToDatabase() {
        con = null;

        connect();

        close();
    }

    private void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team006", "team006", "72b1d11b");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void close() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("closed");
        }
    }

    public static void main(String[] args) {
        ConnectToDatabase c = new ConnectToDatabase();

    }

}
