package controle.ejb;

import java.util.Map;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.SessionAware;




import articles.GestArticleInterface;

import com.opensymphony.xwork2.ActionSupport;

public class ArticlesManager extends ActionSupport implements SessionAware{
 
	Map<String, Object> session;
	
	public void getInstance(){
		Properties props = new Properties();
		props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
		props.setProperty("org.omg.CORBA.ORBInitialPort", "8080");
		InitialContext ctx;
		try {
			ctx = new InitialContext(props);
			GestArticleInterface bean = (GestArticleInterface) ctx
					.lookup("java:global/EARTest/GestionArticles/GestionArticles!GestArticleInterface");
			System.out.println(bean.getArticles());
			

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("salut");
		
		session.put("lu", "HUEHUEHU");
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	
}
