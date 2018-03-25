package com.kodilla.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class RemoteDbManager {
    private Connection conn;
    private static RemoteDbManager dbManagerInstance;

    private RemoteDbManager() throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user","kodilla");
        connectionProps.put("password","kodilla_password");
        conn = DriverManager.getConnection("jdbc:mysql://192.168.1.163:3306/sakila" +
                "?serverTimezone=Europe/Warsaw&useSSL=False", connectionProps);
    }

    public static RemoteDbManager getInstance() throws SQLException {
        if (dbManagerInstance == null) {
            synchronized (RemoteDbManager.class) {
                if (dbManagerInstance == null) {
                    dbManagerInstance = new RemoteDbManager();
                }
            }
        }
        return dbManagerInstance;
    }

    public Connection getConnection() {
        return conn;
    }
}