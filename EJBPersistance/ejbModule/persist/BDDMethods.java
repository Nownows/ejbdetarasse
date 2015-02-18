package persist;
import java.util.List;

import javax.ejb.Remote;

import model.Article;
import model.Categorie;
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
	public Categorie getCategorieById(Integer id);
	
	public List<Article> getAllArticles();
	public List<Journaliste> getAllJournalistes();
	public List<Article> getArticlesLessThan(Float price);
	public List<Categorie> getAllCategories();
	public List<Article> getArticlesByJournaliste(Journaliste j);
	public List<Article> getArticlesNotValidated();
	public void addCategorieArticle(Integer idA, Integer idC);
	public void addArticleCategorie(Integer idC, Integer idA);
	
	
	public Lecteur authentificationLecteur(String email, String mdp);
	public Journaliste authentificationJournaliste(String email, String mdp);
	public Redacteur authentificationRedacteur(String email, String mdp);
	public ResponsableFacturation authentificationResponsable(String email, String mdp);
	
	public void updateArticle(Article a);
}
