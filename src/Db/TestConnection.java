package Db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestConnection {

    private static Connection conn;

    public static Connection getConn() throws ClassNotFoundException, IOException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.jdbc.Driver");
        MyProperties mp = new MyProperties();
        Properties p = mp.myprop();
        String host = p.getProperty("host");
        String port = p.getProperty("port");
        String baza = p.getProperty("baza");
        String username = p.getProperty("hibernate.connection.username");
        String pass = p.getProperty("hibernate.connection.password");

        conn = DriverManager.
                getConnection("jdbc:mysql://" + host + ":" + port + "/" + baza, username, pass);

        return conn;

    }

    public static boolean testConnection() throws ClassNotFoundException, IOException {

        try {
            conn = getConn();

            return conn.isValid(0);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return false;
    }
}
