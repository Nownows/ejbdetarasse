package persist;
import java.util.List;

import javax.ejb.Remote;

import model.Article;
import model.Categorie;
import model.Dossier;
import model.Employe;
import model.Journaliste;
import model.Lecteur;
import model.Note;
import model.Redacteur;
import model.ResponsableFacturation;


@Remote
public interface BDDMethods {
	public void insertLecteur(Lecteur l);
	public void insertRedacteur(Redacteur r);
	public void insertArticle(Article a);
	public void insertJournalist(Journaliste j);
	public void insertNote(Note n);
	public void insertCategorie(Categorie c);
	public void insertResponsableFacturation(ResponsableFacturation r);
	
	public Redacteur getRedacteurById(Integer id);
	public Journaliste getJournalisteById(Integer id);
	public Article getArticleById(Integer id);
	public Lecteur getLecteurById(Integer id);
	public Categorie getCategorieById(Integer id);
	
	public List<Article> getAllArticles();
	public List<Journaliste> getAllJournalistes();
	public List<Article> getArticlesLessThan(Float price);
	public List<Categorie> getAllCategories();
	public List<Article> getArticlesByJournaliste(Employe j);
	public List<Article> getArticlesNotValidated();
	public void addCategorieArticle(Integer idA, Integer idC);
	public void addArticleCategorie(Integer idC, Integer idA);
	
	
	public Lecteur authentificationLecteur(String email, String mdp);
	public Journaliste authentificationJournaliste(String email, String mdp);
	public Redacteur authentificationRedacteur(String email, String mdp);
	public ResponsableFacturation authentificationResponsable(String email, String mdp);
	public Employe authentificationEmploye(String email, String mdp);
	public void updateArticle(Article a);
	public void acheterArticle(int idLecteur, int idArticle);
	
	public void creerDossier(Journaliste j, String label);
	public Dossier getDossierById(int id);
	public List<Dossier> getAllDossiersFromJournalist(Journaliste j);
	public List<Dossier> getAllDossiers();
	public List<Dossier> getAllValidatedDossiers();
	public List<Dossier> getAllNonValidatedDossiers();
	public void ajouterArticleDossier(Dossier d, Article a);
	public void removeArticleDossier(Dossier d, Article a);
	public void validateDossier(Dossier d, Redacteur r);
	public boolean isArticleInDossier(Dossier d, Article a);
	public List<Article> getArticlesNotInDossier(Dossier d);
	
//	public Boolean estConsultable(int idArticle, int idLecteur);
}
