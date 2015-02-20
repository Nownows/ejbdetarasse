package controle.employe;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.SessionAware;

import model.Article;
import model.Journaliste;
import articles.GestArticleInterface;

import com.opensymphony.xwork2.ActionSupport;

public class ValidationArticlesManager  extends ActionSupport implements SessionAware{

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
	
	
	@Override
	public String execute() throws Exception {
		init();
		List<Article> la = bean.getArticlesNotValidated();
		session.put("articlesNotValidated", la);
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;	
	}
}
