package sources.models;

public class Album {
    int id, artist_id, release_year;
    String name;

    public Album(int id, int artist_id, int release_year, String name) {
        this.id = id;
        this.artist_id = artist_id;
        this.release_year = release_year;
        this.name = name;
    }

    //<editor-fold desc="GETTERS AND SETTERS">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //</editor-fold>
}
