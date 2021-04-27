package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import dao.ClientDao;
import models.Client;
import utils.EntityManagerUtility;

public class ClientDaoImpl implements ClientDao {

	private EntityManager em = EntityManagerUtility.getInstance();
	
	public Client findById(Integer id) {
		Client client = null;
		try {
			TypedQuery<Client> query = em.createQuery("FROM Client c WHERE c.id = :id", Client.class);
			query.setParameter("id", id);
			client = query.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return client;
	}

	public void create(Client client) {
		try {
			EntityTransaction trans = em.getTransaction();
			trans.begin();
				em.persist(client);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Client findByEmail(String email) {
		System.out.println("email = " + email);
		
		Client client = null;
		
		try {
			TypedQuery<Client> query = em.createQuery("FROM Client c WHERE c.email = :email", Client.class);
			query.setParameter("email", email);
			client = query.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return client;
	}

}
