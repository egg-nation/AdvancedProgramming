package sources.DAOPatterns;

import sources.models.Album;

import java.util.List;

public interface AlbumDAOPattern {
    void create(String name, int artistId, int releaseYear);
    List<Album> findByArtist(int artistId);
}
