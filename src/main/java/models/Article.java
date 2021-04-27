package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "articles")
public class Article {
	@Id
	private String codeArticle;
	
	private String designation;
	
	private Double prix;
	
	private Integer stock;
	
	@ManyToOne
	@JoinColumn(name = "categorie")
	private Category categorie;
	
	private String photo;
	
	@OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
	private List<LigneCommande> ligneCommandes;
	
	public Article() {
		super();
	}

	public String getCodeArticle() {
		return codeArticle;
	}
	
	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public Double getPrix() {
		return prix;
	}
	
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	
	public Integer getStock() {
		return stock;
	}
	
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	public Category getCategorie() {
		return categorie;
	}
	
	public void setCategorie(Category categorie) {
		this.categorie = categorie;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	

	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

//	@Override
//	public String toString() {
//		return "Article [codeArticle=" + codeArticle + ", designation=" + designation + ", prix=" + prix + ", stock="
//				+ stock + ", categorie=" + categorie + ", photo=" + photo + ", ligneCommandes=" + ligneCommandes + "]";
//	}
	
}
