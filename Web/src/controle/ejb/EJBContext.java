package controle.ejb;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import lecteur.GestLecteurInterface;

public class EJBContext {

	
	private static GestLecteurInterface beanLecteur = null;
	
	
	public static GestLecteurInterface getEJBLecteur(){
		if (beanLecteur == null) {
			Properties props = new Properties();
			props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
			props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
			InitialContext ctx;
			try {
				ctx = new InitialContext(props);
				beanLecteur = (GestLecteurInterface) ctx
						.lookup("java:global/EARTest/Gestion/GestionLecteurs!lecteur.GestLecteurInterface");
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return beanLecteur;
	}
}
