package controle.lecteur;


import java.util.Map;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.SessionAware;

import model.Article;
import model.Dossier;
import model.Journaliste;
import model.Lecteur;
import articles.GestArticleInterface;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ArticleManager extends ActionSupport implements SessionAware {
	private int idArticle;
	Map<String, Object> session;

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

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

	@Override
	public String execute() throws Exception {
		init();
		String[] idS = (String[]) ActionContext.getContext().getParameters().get("idArticle");
		String[] idD = (String[]) ActionContext.getContext().getParameters().get("idDossier");
		
		Lecteur lecteur = (Lecteur) ActionContext.getContext().getSession().get("lecteur");
		if (idS != null) {
			idArticle = Integer.parseInt(idS[0]);
			Article a = bean.getArticleById(idArticle);		
			session.put("article", a);
			boolean consultation = bean.estConsultable(idArticle, lecteur.getId());	
			session.put("consultation", consultation);	
		}	
		
			
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
