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

}
