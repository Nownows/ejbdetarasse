package articles;
import java.util.List;
import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persist.BDDMethods;
import model.Article;
import model.Categorie;
import model.Dossier;
import model.Employe;
import model.Journaliste;
import model.Redacteur;

@Stateless
public class GestionArticles implements GestArticleInterface {
	
	private BDDMethods bean;

	private BDDMethods initEJB() {
		try {
			Properties props = new Properties();
			props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
			props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
			InitialContext ctx;
			ctx = new InitialContext(props);
			return (BDDMethods) ctx
					.lookup("java:global/EARTest/EJBPersistance/BDDAccessClass!persist.BDDMethods");
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private void initBean(){
		if (this.bean == null){
			this.bean = initEJB();	
		}
	}

	@Override
	public List<Article> getArticles() {
		initBean();
		return bean.getAllArticles();
	}

	@Override
	public Article getArticleById(Integer id) {
		initBean();
		return bean.getArticleById(id);
	}

	@Override
	public List<Article> getArticlesCostsLessThan(Float price) {
		initBean();
		return bean.getArticlesLessThan(price);
	}

	@Override
	public List<Article> getArticlesByJournalist(Employe j) {
		initBean();
		return bean.getArticlesByJournaliste(j);
	}

	@Override
	public void insertArticle(Article a) {
		initBean();
		bean.insertArticle(a);
		
	}

	@Override
	public void updateArticle(Article a) {
		initBean();
		bean.updateArticle(a);	
	}

	@Override
	public void addCategorieArticle(Integer idA, Integer idC) {
		initBean();
		bean.addCategorieArticle(idA, idC);		
	}

	@Override
	public void addArticleCategorie(Integer idC, Integer idA) {
		initBean();
		bean.addArticleCategorie(idC, idA);	
	}

	@Override
	public Categorie getCategorieById(Integer id) {
		initBean();
		return bean.getCategorieById(id);
	}

	@Override
	public List<Categorie> getAllCategories() {
		initBean();
		return bean.getAllCategories();
	}

	@Override
	public List<Article> getArticlesNotValidated() {
		initBean();
		return bean.getArticlesNotValidated();
	}

	@Override
	public boolean estConsultable(int idArticle, int idLecteur) {
		initBean();
		return bean.estConsultable(idArticle, idLecteur);
	}

	@Override
	public List<Dossier> getAllDossiers() {
		initBean();
		return null;
	}

	@Override
	public void createDossier(Journaliste j, String label) {
		initBean();
		bean.creerDossier(j, label);
		
	}

	@Override
	public void addArticleDossier(Dossier d, Article a) {
		initBean();
		bean.ajouterArticleDossier(d, a);
		
	}

	@Override
	public void removeArticleDossier(Dossier d, Article a) {
		initBean();
		bean.removeArticleDossier(d, a);
	}

	@Override
	public void validateDossier(Dossier d, Redacteur r) {
		initBean();
		bean.validateDossier(d, r);	
	}

}
