package dbManager;

import java.sql.*;

/**
 * @author Jake Sturgeon
 * @version 1.0 on 17/11/2017
 */
public class InterfaceToDatabase {

    Connection con;  //Connect to db
    public InterfaceToDatabase() {
        this.con = connect();
    }

    private java.sql.Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team006", "team006", "72b1d11b");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Connection closed");
        }
    }
    public void closeStmt(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("statement closed");
        }
    }

    public void endAll(Statement st) {
        closeStmt(st);
        closeConnection();
    }

    public static void main(String[] args) {
        InterfaceToDatabase c = new InterfaceToDatabase();
        c.closeConnection();
    }

}
