package dao;

import models.Commande;

public interface CommandeDao {
	public void create(Commande commande);
	public void delete(Integer numCommande);
	public Commande findByCodeClient(Integer codeClient);
}
