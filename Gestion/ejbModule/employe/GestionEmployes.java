package employe;

import java.util.Properties;

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.Employe;
import persist.BDDMethods;

@Stateless
public class GestionEmployes implements GestEmployesInterface{
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

	private void initBean() {
		if (this.bean == null) {
			this.bean = initEJB();
		}
	}

	@Override
	public Employe authentification(String mail, String pass) {
		initBean();
		return bean.authentificationEmploye(mail, pass);
	}
}
