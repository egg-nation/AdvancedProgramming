package repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import model.Album;
import util.PersistenceUtil;

public class AlbumRepository {
	public static void create(Album album){
		EntityManager manager = PersistenceUtil.createEntityManager();
	    manager.getTransaction().begin();
		
	    manager.persist(album);
	    manager.getTransaction().commit();
	    manager.close();
	}
	public static Album findById(int id) throws NullPointerException {
		Album currAlbum = null;
		EntityManager manager = PersistenceUtil.createEntityManager();
		currAlbum = manager.find(Album.class, id);
		manager.close();
		return currAlbum;
	}
	public static List<Album> findByName(String name) throws NullPointerException {
		List<Album> patternSearchResult = null;
		EntityManager manager = PersistenceUtil.createEntityManager();
		String queryString = "SELECT x FROM Album x WHERE x.name LIKE '"+name+"'";
		Query query = manager.createQuery(queryString);
		patternSearchResult = (List<Album>) query.getResultList(); 
		manager.close();
		return patternSearchResult;
	}
}
