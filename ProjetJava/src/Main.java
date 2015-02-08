import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.Article;
import model.Categorie;
import model.Journaliste;
import model.Lecteur;
import model.Note;
import model.Redacteur;
import model.ResponsableFacturation;

public class Main {

	public static void main(String[] args) throws NamingException {

		Properties props = new Properties();
		props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
		props.setProperty("org.omg.CORBA.ORBInitialPort", "8218");
		InitialContext ctx;
		try {
			ctx = new InitialContext(props);
			BDDMethods bean = (BDDMethods) ctx
					.lookup("java:global/EARTest/EJBPersistance/BDDAccessClass!BDDMethods");
			
			

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	/*	TestBD tdb = new TestBD();
		tdb.test();*/
	}
}
