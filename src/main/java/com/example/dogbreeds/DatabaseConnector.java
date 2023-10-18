package com.example.dogbreeds;

import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static Properties properties = new Properties();

    static {
        // Load configuration from properties file
        try (InputStream input = DatabaseConnector.class.getClassLoader().getResourceAsStream("config.properties.txt")) {
            //load a properties file from class path, inside static method
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Connection connect() {
        try {
            // Get properties
            String url = properties.getProperty("database.url");
            String user = properties.getProperty("database.user");
            String password = properties.getProperty("database.password");

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
}
