package jdbc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBase {

    private Properties prop = new Properties();
    private Connection conn;
    private final String url = "jdbc:postgresql://localhost/dummy";

    private static DataBase db;

    private DataBase() {
        try {
            prop.put("user", "coder");
            prop.put("password", "coder");
            conn = DriverManager.getConnection(url, prop);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection(){
        return conn;
    }

    public static DataBase getInstance() {
        if (db == null) {
            db = new DataBase();
        }
        return db;
    }

}
