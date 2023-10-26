package com.backend.parcial.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection {
    public static Connection getConection() throws ClassNotFoundException, SQLException{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/parcial1", "sa", "sa");
    }
}
