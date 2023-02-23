package com.jdbl44.library.management.system.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionManager {
    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "Zebra@3212");
            return connection;
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return null;

    }


}
