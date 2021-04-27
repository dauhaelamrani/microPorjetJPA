package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
	
	@Id
	private String refCat;
	
	private String cat;
	
	@OneToMany(mappedBy = "categorie", fetch = FetchType.LAZY)
	private List<Article> articles;
	
	public Category() {
		super();
	}
	
	public Category(String refCat, String cat) {
		super();
		this.refCat = refCat;
		this.cat = cat;
	}
	
	public String getRefCat() {
		return refCat;
	}
	
	public void setRefCat(String refCat) {
		this.refCat = refCat;
	}
	
	public String getCat() {
		return cat;
	}
	
	public void setCat(String cat) {
		this.cat = cat;
	}
	
	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "Category [refCat=" + refCat + ", cat=" + cat + "]";
	}
	
}
