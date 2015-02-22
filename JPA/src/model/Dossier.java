package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dossier")
public class Dossier implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8587072117254748L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	@ManyToOne(targetEntity=Journaliste.class,fetch=FetchType.EAGER)
	@JoinColumn(name="journaliste")
	private Journaliste journaliste;
	@ManyToOne(targetEntity=Redacteur.class,fetch=FetchType.EAGER)
	@JoinColumn(name="validateur")
	private Redacteur validateur;
	@Column(name="libelle")
	private String libelle;
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="dossiers_articles")
	private List<Article> lesArticles;
	
	public List<Article> getLesArticles() {
		return lesArticles;
	}
	public void setLesArticles(List<Article> lesArticles) {
		this.lesArticles = lesArticles;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Journaliste getJournaliste() {
		return journaliste;
	}
	public void setJournaliste(Journaliste journaliste) {
		this.journaliste = journaliste;
	}
	public Redacteur getValidateur() {
		return validateur;
	}
	public void setValidateur(Redacteur validateur) {
		this.validateur = validateur;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public void addArticle(Article a){
		this.lesArticles.add(a);
	}
	public void removeArticle(Article a){
		for (int i=0;i<lesArticles.size();i++){
			if (lesArticles.get(i).getIdArticle() == a.getIdArticle()){
				lesArticles.remove(i);
				return;
			}
		}
	}
	public boolean isPresentArticle(Article a){
		for (int i=0;i<lesArticles.size();i++){
			if (lesArticles.get(i).getIdArticle() == a.getIdArticle()){
				return true;
			}
		}
		return false;
	}
}
