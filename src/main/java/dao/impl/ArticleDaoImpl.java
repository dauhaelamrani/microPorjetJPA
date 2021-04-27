package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import dao.ArticleDao;
import models.Article;
import utils.EntityManagerUtility;

public class ArticleDaoImpl implements ArticleDao {

	private EntityManager em = EntityManagerUtility.getInstance();

	public List<Article> findAll() {
		List<Article> articles = null;	
		try {
			TypedQuery<Article> query = em.createQuery("FROM Article", Article.class);
			articles = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return articles;
	}

	public Article findByCodeArticle(String codeArticle) {
		Article article = null;
		
		try {
			TypedQuery<Article> query = em.createQuery("FROM Article a WHERE a.codeArticle = :codearticle", Article.class);
			query.setParameter("codearticle", codeArticle);
			article = query.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return article;	
	}
	
	

}
