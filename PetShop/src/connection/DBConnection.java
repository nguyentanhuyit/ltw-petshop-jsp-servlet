package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection CreateConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/petshop?useUnicode=true&amp;characterEncoding=utf8?autoReconnect=true&useSSL=false";
            String user = "root";
            String password = "";
            return DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            System.out.println("Error connection " + ex);
        }
        return null;
    }
    public static void main(String[] args) {
        DBConnection cn=new DBConnection();
        System.out.println(cn.CreateConnection());
    }
}