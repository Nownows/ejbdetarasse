package persist;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Article;
import model.ArticleAchat;
import model.Categorie;
import model.Dossier;
import model.Employe;
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
		transac.commit();
		return article;
	}
	
	@Override
	public Lecteur getLecteurById(Integer id) {
		transac.begin();
		Lecteur l = em.find(Lecteur.class, id);
		transac.commit();
		return l;
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
	public List<Article> getArticlesByJournaliste(Employe j) {
		Query query = em.createQuery("select a from Article a where a.journaliste.id = "+j.getId());		
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
	public Lecteur insertLecteur(Lecteur l) {
		transac.begin();
		em.persist(l);
		em.flush();
		transac.commit();	
		return l;
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
		transac.begin();
		Query query = em.createQuery("select l from Lecteur l where l.email = \""+email+"\" AND l.password = \""+mdp+"\"");
		if (query.getResultList().size() == 0 ){
			transac.commit();
			return null;
		}
		transac.commit();
		return (Lecteur) query.getResultList().get(0);
	}

	@Override
	public void updateArticle(Article a) {
		Article article = em.find(Article.class, a.getIdArticle());
		transac.begin();
		article.setCorps(a.getCorps());
		article.setTitre(a.getTitre());
		article.setPrix(a.getPrix());
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
		Query query = em.createQuery("select c from Categorie c");
		return query.getResultList();
	}

	@Override
	public List<Article> getAllArticles() {
		Query query = em.createQuery("select a from Article a WHERE a.validateur != NULL");
		return query.getResultList();
	}

	@Override
	public List<Journaliste> getAllJournalistes() {
		Query query = em.createQuery("select j from Journaliste j");
		return query.getResultList();
	}

	@Override
	public Journaliste authentificationJournaliste(String email, String mdp) {
		transac.begin();
		Query query = em.createQuery("select j from Journaliste j where j.mail = \""+email+"\" AND j.password = \""+mdp+"\"");
		if (query.getResultList().size() == 0 ){
			transac.commit();
			return null;
		}
		transac.commit();
		return (Journaliste) query.getResultList().get(0);
	}

	@Override
	public Redacteur authentificationRedacteur(String email, String mdp) {
		transac.begin();
		Query query = em.createQuery("select r from Redacteur r where r.mail = \""+email+"\" AND r.password = \""+mdp+"\"");
		if (query.getResultList().size() == 0 ){
			transac.commit();
			return null;
		}
		transac.commit();
		return (Redacteur) query.getResultList().get(0);
	}

	@Override
	public ResponsableFacturation authentificationResponsable(String email, String mdp) {
		transac.begin();
		Query query = em.createQuery("select r from ResponsableFacturation r where r.mail = \""+email+"\" AND r.password = \""+mdp+"\"");
		if (query.getResultList().size() == 0 ){
			transac.commit();
			return null;
		}
		transac.commit();
		return (ResponsableFacturation) query.getResultList().get(0);
	}

	@Override
	public List<Article> getArticlesNotValidated() {
		Query query = em.createQuery("select a from Article a WHERE a.validateur = NULL");
		return query.getResultList();
	}

	@Override
	public Employe authentificationEmploye(String email, String mdp) {
		transac.begin();
		Query query = em.createQuery("select e from Employe e where e.mail = \""+email+"\" AND e.password = \""+mdp+"\"");
		if (query.getResultList().size() == 0 ){
			transac.commit();
			return null;
		}
		transac.commit();
		return (Employe) query.getResultList().get(0);
	}
	
	public void acheterArticle(int idLecteur, int idArticle) {
		ArticleAchat aa = new ArticleAchat();
		aa.setA(this.getArticleById(idArticle));
		aa.setL(this.getLecteurById(idLecteur));
		transac.begin();
		em.persist(aa);	
		transac.commit();	
	}


	@Override
	public Boolean estConsultable(int idArticle, int idLecteur) {
		Query query = em.createQuery("select a from ArticleAchat a WHERE a.a.idArticle =:idA"
				+ " AND a.l.id =:idL");
		int nb=0;
		 nb = query.setParameter("idA", idArticle).setParameter("idL", idLecteur).getResultList().size();
		 System.out.println("nb +" + nb);
		 if(nb!=0){
			 return true;
		 }
		 return false;
	}

	@Override
	public Lecteur updateAbonnement(Lecteur l) {
		transac.begin();
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		cal.add(Calendar.YEAR, 1); // to get previous year add -1
		Date nextYear = cal.getTime();
		l.setStatus(1);
		Query query = em
				.createQuery("update Lecteur l set l.dateDebut =:dd, l.dateFin =:df, l.status =1 where l.id =:id");
		query.setParameter("dd", new Date()).setParameter("id", l.getId()).setParameter("df", nextYear);
		query.executeUpdate();
		em.flush();
		transac.commit();
		
		return l;
		
	}

	@Override
	public void creerDossier(Journaliste j, String lib) {
		Dossier d = new Dossier();
		d.setJournaliste(j);
		d.setLibelle(lib);
		transac.begin();
		em.persist(d);	
		transac.commit();
	}

	@Override
	public void ajouterArticleDossier(Dossier d, Article a) {
		Dossier dossier = em.find(Dossier.class, d.getId());
		transac.begin();
		dossier.addArticle(a);
		transac.commit();	
	}

	@Override
	public Dossier getDossierById(int id) {
		transac.begin();
		Dossier dossier = em.find(Dossier.class, id);
		transac.commit();
		return dossier;
	}

	@Override
	public void removeArticleDossier(Dossier d, Article a) {
		Dossier dossier = em.find(Dossier.class, d.getId());
		transac.begin();
		dossier.removeArticle(a);
		transac.commit();
		
	}

	@Override
	public void validateDossier(Dossier d, Redacteur r) {
		Dossier dossier = em.find(Dossier.class, d.getId());
		transac.begin();
		dossier.setValidateur(r);
		transac.commit();
		
	}

	@Override
	public List<Dossier> getAllDossiers() {
		Query query = em.createQuery("select d from Dossier d");
		return query.getResultList();
	}

	@Override
	public List<Dossier> getAllValidatedDossiers() {
		Query query = em.createQuery("select d from Dossier d where d.validateur != NULL");
		return query.getResultList();
	}

	@Override
	public List<Dossier> getAllNonValidatedDossiers() {
		Query query = em.createQuery("select d from Dossier d where d.validateur == NULL");
		return query.getResultList();
	}

}
