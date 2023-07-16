package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBUtils {
    public static Connection getConnection() throws SQLException {
        return  DriverManager.
                getConnection("jdbc:postgresql://localhost:5432/Students", "IgorSQL", "123456");
    }

}
