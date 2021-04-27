package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import dao.LigneCommandeDao;
import models.LigneCommande;
import utils.EntityManagerUtility;

public class LigneCommandeDaoImpl implements LigneCommandeDao {
	
	private EntityManager em = EntityManagerUtility.getInstance();
	
	public LigneCommande findByNumCommandeEtCodeArticle(Integer numCommande, String codeArticle) {
		LigneCommande ligneCommande = null;
		try {
			TypedQuery<LigneCommande> query =  em.createQuery("SELECT lc FROM LigneCommande lc WHERE lc.commande.numCommande = :numCommande and lc.article.codeArticle = :codeArticle", LigneCommande.class);
			query.setParameter("numCommande", numCommande);
			query.setParameter("codeArticle", codeArticle);
			
			ligneCommande = query.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ligneCommande;
	}
	
	public void create(LigneCommande ligneCommande) {
		try {
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.persist(ligneCommande);
			trans.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(LigneCommande ligneCommande) {
		try {
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.merge(ligneCommande);
			trans.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<LigneCommande> findByNumCommande(Integer numCommande) {
		List<LigneCommande> lignesCommande = null;
		
		try {
			TypedQuery<LigneCommande> query =  em.createQuery("SELECT lc FROM LigneCommande lc WHERE lc.commande.numCommande = :numCommande", LigneCommande.class);
			query.setParameter("numCommande", numCommande);
			
			lignesCommande = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lignesCommande;
	}

}
