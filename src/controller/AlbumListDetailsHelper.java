package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.AlbumListDetails;

/**
 * @author akvang - Alexander Vang
 * CIS175 - Spring 2023
 * Feb 9, 2023
 */
public class AlbumListDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AlbumsVang");
	
	public void insertNewAlbumListDetails(AlbumListDetails a) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<AlbumListDetails> getAlbumLists(){
		EntityManager em = emfactory.createEntityManager();
		List<AlbumListDetails> allAlbums = em.createQuery("SELECT d FROM AlbumListDetails d").getResultList();
		return allAlbums;
	}

	public AlbumListDetails searchForAlbumListById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		AlbumListDetails found = em.find(AlbumListDetails.class, tempId);
		em.close();
		return found;
	}

	public void deleteAlbumList(AlbumListDetails deleteAlbumList) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<AlbumListDetails> typedQuery = em.createQuery("SELECT detail FROM AlbumListDetails detail WHERE detail.id = :selectedId", AlbumListDetails.class);
		typedQuery.setParameter("selectedId", deleteAlbumList.getId());
		typedQuery.setMaxResults(1);
		AlbumListDetails result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public void editList(AlbumListDetails listToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(listToEdit);
		em.getTransaction().commit();
		em.close();
	}
}
