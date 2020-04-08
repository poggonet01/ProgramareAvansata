package com.JavaLab8.se.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    static private Database database;
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }
    private Database() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","STUDENT");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    public static Database getInstance() throws SQLException
    {
        if(database == null)
            database= new Database();
        return database;
    }

}
