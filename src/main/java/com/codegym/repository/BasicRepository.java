package com.codegym.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BasicRepository {
    private String jdbcUrl = "jdbc:mysql://localhost:3306/furama_manager";
    private String username = "root";
    private String password = "123456";
    private Connection connection;

    public BasicRepository() {
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcUrl, username, password);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
