package com.JavaLab8.se.task1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlbumController {

    PreparedStatement preparedStatement;
    ResultSet resultSet;
    private String querry;

    public void create(String name,int artistId,int realeaseYear)  throws SQLException {
        querry="INSERT INTO ALBUMS(name,artist_id,release_year) VALUES(?,?,?)";
        preparedStatement = Database.getInstance().getConnection().prepareStatement(querry);
        preparedStatement.setString(1,name);
        preparedStatement.setInt(2,artistId);
        preparedStatement.setInt(3,realeaseYear);
        preparedStatement.executeUpdate();
    }

    public void findByArtist(int artistID) throws SQLException {
        System.out.println("Albums of artist with id "+artistID);
        querry="SELECT * FROM ALBUMS WHERE artist_id=?";
        preparedStatement = Database.getInstance().getConnection().prepareStatement(querry);
        preparedStatement.setInt(1,artistID);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("Album: " + resultSet.getString(2) + " ID: " + resultSet.getInt(1) + " Year: " + resultSet.getInt(4));
        }
        resultSet.close();
    }


}
