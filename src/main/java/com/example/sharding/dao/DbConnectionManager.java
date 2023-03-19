package com.example.sharding.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.postgresql.Driver;



public class DbConnectionManager {

    private final String url;

    private final String username;

    private final String password;

    public DbConnectionManager(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
