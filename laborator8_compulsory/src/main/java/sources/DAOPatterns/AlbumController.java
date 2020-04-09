package sources.DAOPatterns;

import com.sun.org.apache.xerces.internal.xs.XSTerm;
import sources.DAOPatterns.AlbumDAOPattern;
import sources.Database;
import sources.models.Album;

import javax.swing.plaf.nimbus.State;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlbumController implements AlbumDAOPattern {
    Database db;
    public AlbumController() {
        db = Database.getInstance();

    }

    public void create(String name, int artistId, int releaseYear) {
        try {
            Statement statement = db.dbConnection.createStatement();
            String query = String.format("INSERT INTO albums (name, artist_id, release_year) VALUES ('%s', %d, %d)", name, artistId, releaseYear);
            int rowsInserted = statement.executeUpdate(query);
            System.out.println(String.format("Number of rows inserted: %d", rowsInserted));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Album> findByArtist(int artistID) throws NullPointerException {
        ArrayList<Album> albums = new ArrayList<Album>();
        try {
            Statement statement = db.dbConnection.createStatement();
            String query = String.format("SELECT * FROM albums WHERE artist_id=%d", artistID);
            ResultSet set = statement.executeQuery(query);
            while (set.next()) {
                albums.add(new Album(set.getInt(1), set.getInt(2), set.getInt(3),
                        set.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albums.isEmpty() ? null : albums;
    }

}
