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

    public static Connection getConnection() {
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team006", "team006", "72b1d11b");
        } catch(Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}
