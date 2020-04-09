package sources.DAOPatterns;

import sources.models.Artist;

import java.util.List;

public interface ArtistDAOPattern {
    void create(String name, String country);
    Artist findByName(String name);
}
