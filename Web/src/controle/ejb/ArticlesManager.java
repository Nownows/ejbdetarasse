package controle.ejb;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.Article;
import model.Categorie;

import org.apache.struts2.interceptor.SessionAware;

import articles.GestArticleInterface;

import com.opensymphony.xwork2.ActionSupport;

public class ArticlesManager extends ActionSupport implements SessionAware {

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
		session.remove("idCategorie");
		init();
		List<Article> articles = bean.getArticles();
		List<Categorie> categories = bean.getAllCategories();
		session.put("articles", articles);
		session.put("categories", categories);
		return SUCCESS;

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
