package journaliste;

import java.util.List;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.Journaliste;
import persist.BDDMethods;

@Stateless
public class GestionJournalistes implements GestJournalistesInterface{
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
	public void insertJournaliste(Journaliste j) {
		initBean();
		bean.insertJournalist(j);
	}

	@Override
	public Journaliste getJournalisteById(Integer id) {
		initBean();
		return bean.getJournalisteById(id);
	}

	@Override
	public List<Journaliste> getJournalistes() {
		initBean();
		return bean.getAllJournalistes();
	}

	@Override
	public Journaliste authentification(String mail, String pass) {
		initBean();
		return bean.authentificationJournaliste(mail, pass);
	}
}
