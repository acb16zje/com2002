package dbManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jake Sturgeon
 * @version 1.0 on 17/11/2017
 */
public class Database {

    Connection con;  //Connect to db
    public Database() {
        this.con = connect();
    }
    
    public Connection getCon()	{
    	return con;
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
        Database c = new Database();
        c.closeConnection();
    }

}
