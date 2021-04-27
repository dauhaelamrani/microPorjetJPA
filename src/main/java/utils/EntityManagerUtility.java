package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtility {
	
	private EntityManagerFactory entityManagerFactory = null;
	private EntityManager entityManager = null;
	
	private EntityManagerUtility() {
		try {
			
			entityManagerFactory = Persistence.createEntityManagerFactory("microProjet");
			
			entityManager = entityManagerFactory.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static EntityManager getInstance() {
		return new EntityManagerUtility().entityManager;
	}
}
