package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.User;

/**
 * @author akvang - Alexander Vang
 * CIS175 - Spring 2023
 * Feb 9, 2023
 */
public class UserHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AlbumsVang");
	
	public void insertUser(User u) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<User> showAllUsers(){
		EntityManager em = emfactory.createEntityManager();
		List<User> allUsers = em.createQuery("SELECT u FROM User u").getResultList();
		return allUsers;
	}

	public User findUser(String userName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<User> typedQuery = em.createQuery("SELECT u from User u WHERE u.name = :selectedName", User.class);
		typedQuery.setParameter("selectedName", userName);
		typedQuery.setMaxResults(1);
		User found;
		try {
			found = typedQuery.getSingleResult();
		} catch(NoResultException e) {
			found = new User(userName);
		}
		em.close();
		return found;

	}
}
