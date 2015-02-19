package articleLecteur;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import model.Article;
import model.Categorie;
import model.Journaliste;

@Remote
public interface GestArticleLecteurInterface extends Serializable{
//	public boolean estConsultable(int idArticle, int idLecteur);

	
}
