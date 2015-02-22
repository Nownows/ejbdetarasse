package articles;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import model.Article;
import model.Categorie;
import model.Dossier;
import model.Employe;
import model.Journaliste;
import model.Redacteur;

@Remote
public interface GestArticleInterface extends Serializable{
	public Article getArticleById(Integer id);
	public List<Article> getArticles();
	public List<Article> getArticlesCostsLessThan(Float price);
	public List<Article> getArticlesByJournalist(Employe j);
	public List<Article> getArticlesNotValidated();
	public void insertArticle(Article a);
	public void updateArticle(Article a);
	public void addCategorieArticle(Integer idA, Integer idC);
	public void addArticleCategorie(Integer idC, Integer idA);
	public Categorie getCategorieById(Integer id);
	public List<Categorie> getAllCategories();
	/*
	 * Gestion des dossiers
	 */
	public List<Dossier> getAllDossiers();
	public void createDossier(Journaliste j, String label);
	public void addArticleDossier(Dossier d, Article a);
	public void removeArticleDossier(Dossier d, Article a);
	public void validateDossier(Dossier d, Redacteur r);
	public List<Dossier> getAllDossiersFromJournalist(Journaliste j);
	public boolean articleIsPresent(Dossier d, Article a);
	public Dossier getDossierById(int idDossier);
	public List<Article> getArticlesNotInDossier(Dossier d);
	public List<Dossier> getAllNonValidatedDossiers();
	
}
