package controle.employe;

import java.util.Map;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.SessionAware;

import model.Article;
import model.Journaliste;
import articles.GestArticleInterface;

import com.opensymphony.xwork2.ActionSupport;

public class AjoutArticle  extends ActionSupport implements SessionAware{

	private String titre;
	private String header;
	private String corps;
	private String prix;
	Map<String, Object> session;
	
	private static GestArticleInterface bean = null;

	private static void init() {
		if (bean == null) {
			Properties props = new Properties();
			props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
			props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
			InitialContext ctx;
			try {
				ctx = new InitialContext(props);
				bean = (GestArticleInterface) ctx
						.lookup("java:global/EARTest/Gestion/GestionArticles!articles.GestArticleInterface");

			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getCorps() {
		return corps;
	}


	public void setCorps(String corps) {
		this.corps = corps;
	}


	public String getPrix() {
		return prix;
	}


	public void setPrix(String prix) {
		this.prix = prix;
	}


	@Override
	public String execute() throws Exception {
		init();
		Article a = new Article();
		a.setTitre(titre);
		a.setHeader(header);
		a.setCorps(corps);
		a.setPrix(Float.valueOf(prix));
		a.setJournaliste((Journaliste)session.get("employe"));
		a.setValidateur(null);
		bean.insertArticle(a);
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;	
	}
}
