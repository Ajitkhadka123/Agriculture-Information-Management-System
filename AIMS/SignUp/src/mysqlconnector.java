import java.sql.*;
import javax.swing.*;
public class mysqlconnector {
    Connection conn = null;
    static String url = "jdbc:mysql://localhost/agriculture";
    static String username= "root";
    static String password="1234";
    public static Connection dbConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,username,password);
            JOptionPane.showMessageDialog(null,"Connection successful");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }

}
