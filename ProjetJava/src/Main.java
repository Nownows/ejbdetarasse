import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.Article;
import model.Categorie;
import model.Journaliste;
import model.Lecteur;
import model.Note;
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
			
		/*	Lecteur l = new Lecteur();
			l.setEmail("toto@toto.fr");
			l.setNom("nom");
			l.setPrenom("prenom");
			l.setPassword("pasw");
			l.setPays("fr");
			l.setStatus(0);
			bean.insertLecteur(l);*/
			
			System.out.println(bean.authentificationLecteur("toto@toto.fr", "pasw"));
			
			

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	/*	TestBD tdb = new TestBD();
		tdb.test();*/
	}
}
