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
	public Redacteur getRedacteurById(Integer id);
	
	public Article getArticleById(Integer id);
	public List<Article> getArticlesLessThan(Float price);
	public Journaliste getJournalisteById(Integer id);
	public List<Article> getArticlesByJournaliste(Journaliste j);
	public Categorie getCategorieById(Integer id);
	public void addCategorieArticle(Integer idA, Integer idC);
	public void addArticleCategorie(Integer idC, Integer idA);
	public void insertResponsableFacturation(ResponsableFacturation r);
	
	public Lecteur authentificationLecteur(String email, String mdp);
	
	public void updateArticle(Article a);
}
