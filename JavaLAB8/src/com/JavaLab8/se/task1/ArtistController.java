package com.JavaLab8.se.task1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistController {

    PreparedStatement preparedStatement;
    ResultSet resultSet;
    private String querry;

    public void create(String name, String country) throws SQLException {
        querry="INSERT INTO ARTISTS(name,country) VALUES(?,?)";
        preparedStatement = Database.getInstance().getConnection().prepareStatement(querry);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,country);
        preparedStatement.executeUpdate();
    }

    public int findByName(String name) throws SQLException {
        querry="SELECT ID FROM ARTISTS WHERE name=?";
        preparedStatement = Database.getInstance().getConnection().prepareStatement(querry);
        preparedStatement.setString(1,name);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int result = resultSet.getInt(1);
        preparedStatement.close();
        return result;
    }

}
