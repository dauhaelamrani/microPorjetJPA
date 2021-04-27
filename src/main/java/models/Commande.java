package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "commandes")
public class Commande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer numCommande;
	
	@ManyToOne
	@JoinColumn(name = "codeClient")
	private Client client;
	
	private Date dateCommande;
	
	@OneToMany(mappedBy = "commande")
	private List<LigneCommande> ligneCommandes;
	
	public Commande() {
		super();
	}
	
	public Integer getNumCommande() {
		return numCommande;
	}
	
	public void setNumCommande(Integer numCommande) {
		this.numCommande = numCommande;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Date getDateCommande() {
		return dateCommande;
	}
	
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	

	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	@Override
	public String toString() {
		return "Commande [numCommande=" + numCommande + ", client=" + client + ", dateCommande=" + dateCommande + "]";
	}
	
}
