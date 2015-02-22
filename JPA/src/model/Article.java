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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article implements Serializable{
	private static final long serialVersionUID = -683815592646116456L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int idArticle;
	@Column(name="titre")
	private String titre;
	@Column(name="header")
	private String header;
	@Column(name="corps",length=4000)
	private String corps;
	@Column(name="prix")
	private Float prix;
	@ManyToOne(targetEntity=Journaliste.class,fetch=FetchType.EAGER)
	@JoinColumn(name="journaliste")
	private Journaliste journaliste;
	@ManyToMany(mappedBy="lesArticles",fetch=FetchType.EAGER)
    private List<Categorie> lesCategories ;
	@ManyToOne(targetEntity=Redacteur.class,fetch=FetchType.EAGER)
	@JoinColumn(name="id_validator")
	private Redacteur validateur;
	
	public Redacteur getValidateur() {
		return validateur;
	}
	public void setValidateur(Redacteur validateur) {
		this.validateur = validateur;
	}
	public String getCorps() {
		return corps;
	}
	public void setCorps(String corps) {
		this.corps = corps;
	}
	public void addCatg(Categorie c){
		lesCategories.add(c);
	}
	public List<Categorie> getLesCategories() {
		return lesCategories;
	}
	public void setLesCategories(List<Categorie> lesCategories) {
		this.lesCategories = lesCategories;
	}
	public Journaliste getJournaliste() {
		return journaliste;
	}
	public void setJournaliste(Journaliste journaliste) {
		this.journaliste = journaliste;
	}
	public Article(){
		lesCategories = new ArrayList<Categorie>();
	}
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Float getPrix() {
		return prix;
	}
	public void setPrix(Float prix) {
		this.prix = prix;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	
	
}
