package main;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import persist.BDDMethods;
import articles.GestArticleInterface;
import lecteur.GestLecteurInterface;
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
		props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
		InitialContext ctx;
		try {
			ctx = new InitialContext(props);
			GestLecteurInterface bean = (GestLecteurInterface) ctx
					.lookup("java:global/EARTest/Gestion/GestionLecteurs!lecteur.GestLecteurInterface");
			bean.acheterArticle(1, 1);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
		
	/*	TestBD tdb = new TestBD();
		tdb.test();*/
	}
}
