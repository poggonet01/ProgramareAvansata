
package com.JavaLab8.se.task;

import com.JavaLab8.se.task1.AlbumController;
import com.JavaLab8.se.task1.ArtistController;
import com.JavaLab8.se.task1.Database;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try {
            //Se creaza doua controlere
            ArtistController artistController = new ArtistController();
            AlbumController albumController = new AlbumController();

            //Inseram in baza de date artistii
            artistController.create("Artist1", "Country1");
            artistController.create("Artist2", "Country2");

            // Pentru fieacre artist se inseareaza cate un album id-ul artistului preluandu-se cu ajutorul metodei din artistController
            albumController.create("Album1",artistController.findByName("Artist1"),2001);
            albumController.create("Album2",artistController.findByName("Artist2"),2011);

            // Se preia lista cu albumele primului si celui de-al doilea artist.
            albumController.findByArtist(artistController.findByName("Artist1"));
            albumController.findByArtist(artistController.findByName("Artist2"));

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        // La final se inchide conexiunea cu baza noastra de date
        finally {
            try{
                Database.getInstance().getConnection().close();
            }
            catch (Exception ignored) {}
        }

    }
}
