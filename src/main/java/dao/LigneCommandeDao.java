package dao;

import java.util.List;

import models.LigneCommande;

public interface LigneCommandeDao {
	public void create(LigneCommande ligneCommande);
	public void update(LigneCommande ligneCommande);
	public LigneCommande findByNumCommandeEtCodeArticle(Integer numCommande, String codeArticle);
	public List<LigneCommande> findByNumCommande(Integer numCommande);
}
