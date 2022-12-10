package com.masai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component("dbconnect")
public class DBConnect {

    @Autowired
    Environment env;

    public Connection getConnection() throws SQLException {

        try {
            Class.forName(env.getProperty("db.driverName"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return DriverManager.getConnection(env.getProperty("db.url"),
                env.getProperty("db.username"),
                env.getProperty("db.password"));
    }

}
