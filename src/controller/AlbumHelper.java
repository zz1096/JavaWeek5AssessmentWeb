package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Album;

/**
 * @author akvang - Alexander Vang
 * CIS175 - Spring 2023
 * Jan 23, 2023
 */
public class AlbumHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AlbumsVang");

	public void cleanUp() {
		emfactory.close();
	}

	public void addAlbum(Album add) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(add);
		em.getTransaction().commit();
		em.close();
	}

	public void deleteAlbum(Album delete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Album> typedQuery = em.createQuery("select al from Album al where al.albumName = :findName and al.artist = :findArtist", Album.class);
		
		typedQuery.setParameter("findName", delete.getAlbumName());
		typedQuery.setParameter("findArtist", delete.getArtist());
		
		typedQuery.setMaxResults(1);
		
		Album result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public List<Album> showAllAlbums() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		List<Album> allAlbums = em.createQuery("SELECT i FROM Album i").getResultList();

		return allAlbums;
	}

	public Album findAlbum(Album find) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Album> typedQuery = em.createQuery("select al from Album al where al.albumName = :findName and al.artist = :findArtist", Album.class);
		
		typedQuery.setParameter("findName", find.getAlbumName());
		typedQuery.setParameter("findArtist", find.getArtist());
		
		typedQuery.setMaxResults(1);
		Album result;
		List<Album> albumList = typedQuery.getResultList();
		if(albumList.size() == 0) {
			result = null;
		}
		else {
			result = typedQuery.getSingleResult();
		}
		em.getTransaction().commit();
		em.close();
		return result;
	}
	
	public Album findAlbumID(int find) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Album result = em.find(Album.class, find);
		em.getTransaction().commit();
		em.close();
		return result;
	}
	
	public void editAlbum(Album edit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(edit);
		em.getTransaction().commit();
		em.close();
	}
}
