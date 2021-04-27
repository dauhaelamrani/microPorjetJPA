package dao.impl;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import dao.CommandeDao;
import models.Commande;
import utils.EntityManagerUtility;

public class CommandeDaoImpl implements CommandeDao {

	private EntityManager em = EntityManagerUtility.getInstance();
	
	public void create(Commande commande) {
		try {
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.persist(commande);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Commande findByCodeClient(Integer codeClient) {
		Commande commande = null;
		
		try {
			TypedQuery<Commande> query = em.createQuery("SELECT c FROM Commande c WHERE c.client.id = :codeclient", Commande.class);
			query.setParameter("codeclient", codeClient);
			
			commande = query.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return commande;
	}

	public void delete(Integer numCommande) {
		try {
			Commande commande = em.find(Commande.class, numCommande);
			
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.detach(commande);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
