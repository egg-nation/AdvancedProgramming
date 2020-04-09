package sources;

import sources.DAOPatterns.AlbumController;
import sources.DAOPatterns.AlbumDAOPattern;
import sources.DAOPatterns.ArtistController;
import sources.DAOPatterns.ArtistDAOPattern;

public class Main {

    public static void main(String[] args) {
        AlbumDAOPattern albumDAO = new AlbumController();
        ArtistDAOPattern artistDAO = new ArtistController();

        artistDAO.create("Bon Jovi", "USA");
        artistDAO.create("Michael Jackson", "USA");
        artistDAO.create("Bob Marley", "Jamaica");

        albumDAO.create("Bad", artistDAO.findByName("Michael Jackson").getId(), 1987);
        albumDAO.create("Dangerous", artistDAO.findByName("Michael Jackson").getId(), 1991);
        albumDAO.create("Thriller", artistDAO.findByName("Michael Jackson").getId(), 1982);
        albumDAO.create("Forever, Michael", artistDAO.findByName("Michael Jackson").getId(), 1975);

        albumDAO.create("Catch a fire", artistDAO.findByName("Bob Marley").getId(), 1973);
        albumDAO.create("Soul rebels", artistDAO.findByName("Bob Marley").getId(),1970);

        albumDAO.create("Slippery when wet", artistDAO.findByName("Bon Jovi").getId(), 1986);

    }
}

