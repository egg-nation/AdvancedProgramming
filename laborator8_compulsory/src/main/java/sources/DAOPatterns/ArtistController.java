package sources.DAOPatterns;

import sources.DAOPatterns.ArtistDAOPattern;
import sources.Database;
import sources.models.Artist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ArtistController implements ArtistDAOPattern {
    Database db;
    public ArtistController() {
        db = Database.getInstance();
    }
    public void create(String name, String country) {
        try {
            Statement statement = db.dbConnection.createStatement();
            String query = String.format("INSERT INTO artists (name, country) VALUES ('%s', '%s')", name, country);
            int rowsInserted = statement.executeUpdate(query);
            System.out.println(String.format("Number of rows inserted: %d", rowsInserted));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Artist findByName(String name) throws NullPointerException {
        Artist lastArtist = null;
        try {
            Statement statement = db.dbConnection.createStatement();
            String query = String.format("SELECT * FROM artists WHERE name='%s'", name);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                lastArtist = new Artist(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                System.out.println(lastArtist);
            }
            return lastArtist;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastArtist;
    }

}
