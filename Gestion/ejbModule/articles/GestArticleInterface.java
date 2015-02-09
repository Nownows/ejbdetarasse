package articles;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import model.Article;
import model.Categorie;
import model.Journaliste;

@Remote
public interface GestArticleInterface extends Serializable{
	public Article getArticleById(Integer id);
	public List<Article> getArticles();
	public List<Article> getArticlesCostsLessThan(Float price);
	public List<Article> getArticlesByJournalist(Journaliste j);
	public void insertArticle(Article a);
	public void updateArticle(Article a);
	public void addCategorieArticle(Integer idA, Integer idC);
	public void addArticleCategorie(Integer idC, Integer idA);
	public Categorie getCategorieById(Integer id);
	public List<Categorie> getAllCategories();
}
