package controle.lecteur;


import java.util.Map;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.SessionAware;

import lecteur.GestLecteurInterface;
import model.Article;
import model.Lecteur;
import articles.GestArticleInterface;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AchatArticle  extends ActionSupport implements SessionAware{

	Map<String, Object> session;


	private static GestLecteurInterface bean = null;
	
	private static void init() {
		if (bean == null) {
			Properties props = new Properties();
			props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
			props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
			InitialContext ctx;
			try {
				ctx = new InitialContext(props);
				bean = (GestLecteurInterface) ctx
						.lookup("java:global/EARTest/Gestion/GestionLecteurs!lecteur.GestLecteurInterface");
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	public String execute() throws Exception {
		init();
		System.out.println("achat d'article");
	Article article =  (Article) ActionContext.getContext().getSession().get("article");
	Lecteur lecteur = (Lecteur) ActionContext.getContext().getSession().get("lecteur");
	bean.acheterArticle(lecteur.getId(), article.getIdArticle());
	System.out.println("achat d'article");
	session.put("consultation", true);	
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;	
	}
}
