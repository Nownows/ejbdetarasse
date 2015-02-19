package articleLecteur;
import java.util.List;
import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persist.BDDMethods;
import model.Article;
import model.Categorie;
import model.Journaliste;

@Stateless
public class GestionArticleLecteur implements GestArticleLecteurInterface {
	
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


//	@Override
//	public boolean estConsultable(int idArticle, int idLecteur) {
//		initBean();
//		return bean.estConsultable(idArticle, idLecteur);
//	}

}
