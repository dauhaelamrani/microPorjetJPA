package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lignescommandes")
public class LigneCommande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "numCommande")
	private Commande commande;
	
	@ManyToOne
	@JoinColumn(name = "codeArticle")
	private Article article;
	
	private Integer qteCode;
	
	public LigneCommande() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Integer getQteCode() {
		return qteCode;
	}

	public void setQteCode(Integer qteCode) {
		this.qteCode = qteCode;
	}

//	@Override
//	public String toString() {
//		return "LigneCommande [commande=" + commande + ", article=" + article + ", qteCode=" + qteCode + "]";
//	}
	
	
}
