package sources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database dbInstance;
    private final String DB_USERNAME = "dba";
    private final String DB_PASSWORD = "sql123";
    private final String DB_CONN_STR = "jdbc:mysql://localhost:3306/musicalbums";
    public Connection dbConnection;

    private Database(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(DB_CONN_STR, DB_USERNAME, DB_PASSWORD);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        if (null == dbInstance)
            dbInstance = new Database();
        return dbInstance;
    }
}
