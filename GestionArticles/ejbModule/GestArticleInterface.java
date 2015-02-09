import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import model.Article;

@Remote
public interface GestArticleInterface extends Serializable{
	public List<Article> getArticles();
	public Article getArticleById(Integer id);
}
