package app;

import java.util.List;

import model.*;
import repo.*;

public class AlbumManager {
	
	static List<Artist> artistsM;
	static List<Album> albumsM;
	public static void main(String[] args) {
		initDB();
		
		System.out.println("ARTIST WITH ID 1");
		System.out.println(ArtistRepository.findById(1));
		
		System.out.println("ARTIST WITH NAME STARTING WITH M");
		artistsM = ArtistRepository.findByName("M%");
		
		System.out.println("FIRST ALBUM");
		System.out.println(AlbumRepository.findById(1));
		
		System.out.println("Albums starting with B");
		albumsM = AlbumRepository.findByName("B%");	
		
	}
	static void initDB() {
		int artistID = 1;
		Artist singer1 = new Artist(artistID++, "Michael Jackson", "USA");
		Artist singer2 = new Artist(artistID++, "Modern Talking", "USA");
		Artist singer3 = new Artist(artistID++, "CTC", "Romania");
		ArtistRepository.create(singer1);
		ArtistRepository.create(singer2);
		ArtistRepository.create(singer3);
		
		int albumID = 1;
		AlbumRepository.create(new Album(albumID++, "Alone", 1999, singer2));
		AlbumRepository.create(new Album(albumID++, "Bad", 1987, singer1));
		AlbumRepository.create(new Album(albumID++, "Back for good", 1998, singer2));
		AlbumRepository.create(new Album(albumID++, "Dangerous", 1982, singer1));
		AlbumRepository.create(new Album(albumID++, "Dificultati tehnice", 2005, singer3));
		AlbumRepository.create(new Album(albumID++, "Ready for romance", 1986, singer2));
		AlbumRepository.create(new Album(albumID++, "Secretul din atom", 2002, singer3));
	}

}
