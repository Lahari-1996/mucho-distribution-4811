package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection provideConnection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
 String url="jdbc:mysql://localhost:3306/miniprojectdb";

        Connection con= null;
        try {
            con = DriverManager.getConnection(url,"root","root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }
}
