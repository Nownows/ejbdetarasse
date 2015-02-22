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

public class AjoutDossier  extends ActionSupport implements SessionAware{

	private String label;
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
	
	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String execute() throws Exception {
		init();	
		bean.createDossier((Journaliste)session.get("journaliste"), this.label);
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;	
	}
}
