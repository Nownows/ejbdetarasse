package controle.ejb;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.Article;

import org.apache.struts2.interceptor.SessionAware;

import articles.GestArticleInterface;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator.Failure;

public class ArticlesManager extends ActionSupport implements SessionAware {

	Map<String, Object> session;
	private static GestArticleInterface bean = null;

	private static GestArticleInterface init() {
		if (bean == null) {
			Properties props = new Properties();
			props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
			props.setProperty("org.omg.CORBA.ORBInitialPort", "8080");
			InitialContext ctx;
			try {
				ctx = new InitialContext(props);
				bean = (GestArticleInterface) ctx
						.lookup("java:global/EARTest/GestionArticles/GestionArticles!GestArticleInterface");
				System.out.println(bean.getArticles());

			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
		return bean;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(bean==null){
			init();
		}
		List<Article> articles = bean.getArticles();
		session.put("articles", articles);
		return SUCCESS;

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
