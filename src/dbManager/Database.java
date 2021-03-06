package dbManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jake Sturgeon
 * @version 1.0 on 17/11/2017
 */
public class Database {

    private Connection con;  //Connect to db

    public Database() {
        this.con = connect();
    }

    public Connection getCon() {
        return con;
    }

    private java.sql.Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager
                .getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team006", "team006", "72b1d11b");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * Close connection
     */
    public void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Close statement
     *
     * @param st The statement
     */
    private void closeStmt(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("statement closed");
        }
    }
}