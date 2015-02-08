import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Article;
import model.Categorie;
import model.Journaliste;
import model.Lecteur;
import model.Note;
import model.Redacteur;
import model.ResponsableFacturation;

@Stateful
public class BDDAccessClass implements BDDMethods{
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
	EntityManager em = emf.createEntityManager();
	EntityTransaction transac = em.getTransaction();

	@Override
	public Article getArticleById(Integer id) {
		transac.begin();
		Article article = em.find(Article.class, id);
		article.getLesCategories().size();
		transac.commit();
		return article;
	}

	@Override
	public List<Article> getArticlesLessThan(Float price) {
		Query query = em.createQuery("select a from Article a where a.prix < "+price);
		return query.getResultList();	 
	}

	@Override
	public void insertArticle(Article a) {
		transac.begin();
		em.persist(a);
		transac.commit();
	}

	@Override
	public void insertJournalist(Journaliste j) {
		transac.begin();
		em.persist(j);
		transac.commit();
		
	}

	@Override
	public Journaliste getJournalisteById(Integer id) {
		transac.begin();
		Journaliste journaliste = em.find(Journaliste.class, id);
		transac.commit();
		return journaliste;
	}

	@Override
	public List<Article> getArticlesByJournaliste(Journaliste j) {
		Query query = em.createQuery("select a from Article a where a.journaliste.idJournaliste = "+j.getId());		
		return query.getResultList();
	}

	@Override
	public void insertNote(Note n) {
		transac.begin();
		em.persist(n);
		transac.commit();	
	}

	@Override
	public void insertCategorie(Categorie c) {
		transac.begin();
		em.persist(c);
		transac.commit();	
	}

	@Override
	public void insertLecteur(Lecteur l) {
		transac.begin();
		em.persist(l);
		transac.commit();	
		
	}

	@Override
	public Categorie getCategorieById(Integer id) {
		transac.begin();
		Categorie cat = em.find(Categorie.class, id);
		cat.getLesArticles().size();
		transac.commit();
		return cat;
	}

	@Override
	public void addCategorieArticle(Integer idA, Integer idC) {
		Article article = em.find(Article.class, idA);
		article.getLesCategories().size();
		Categorie cat = em.find(Categorie.class, idC);
		cat.getLesArticles().size();
		transac.begin();
		article.addCatg(cat);
		transac.commit();	
	}

	@Override
	public void addArticleCategorie(Integer idC, Integer idA) {
		Article article = em.find(Article.class, idA);
		article.getLesCategories().size();
		Categorie cat = em.find(Categorie.class, idC);
		cat.getLesArticles().size();
		transac.begin();
		cat.addArt(article);
		transac.commit();
		
	}

	@Override
	public void insertRedacteur(Redacteur r) {
		transac.begin();
		em.persist(r);	
		transac.commit();
	}

	@Override
	public void insertResponsableFacturation(ResponsableFacturation r) {
		transac.begin();
		em.persist(r);	
		transac.commit();
	}

	@Override
	public Lecteur authentificationLecteur(String email, String mdp) {
		Query query = em.createQuery("select l from Lecteur l where l.email = \""+email+"\" AND l.password = \""+mdp+"\"");
		if (query.getResultList().size() == 0 ){
			return null;
		}
		return (Lecteur) query.getResultList().get(0);
	}

	@Override
	public void updateArticle(Article a) {
		Article article = em.find(Article.class, a.getIdArticle());
		transac.begin();
		article.setCorps(a.getCorps());
		article.setTitre(a.getTitre());
		article.setPrix(a.getPrix());
		article.setJournaliste(a.getJournaliste());
		article.setValidateur(a.getValidateur());
		transac.commit();		
	}

	@Override
	public Redacteur getRedacteurById(Integer id) {
		transac.begin();
		Redacteur r = em.find(Redacteur.class, id);
		transac.commit();
		return r;
	}

	@Override
	public List<Categorie> getAllCategories() {
		Query query = em.createQuery("select c from Categorie c ");
		return query.getResultList();
	}

}
