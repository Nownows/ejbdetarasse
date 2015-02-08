package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorie")
public class Categorie implements Serializable {
	private static final long serialVersionUID = 6012082615419669851L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	@Column(name="libelle")
	private String libelle;
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="Categories_article")
	private List<Article> lesArticles;
	
	public void addArt(Article a){
		lesArticles.add(a);
	}
	public List<Article> getLesArticles() {
		return lesArticles;
	}

	public void setLesArticles(List<Article> lesArticles) {
		this.lesArticles = lesArticles;
	}

	public Categorie(){
		lesArticles = new ArrayList<Article>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
