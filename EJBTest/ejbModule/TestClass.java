import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Stateful
public class TestClass implements EjbLocal, EjbRemote {

	public void maMethode() {
		System.out.println("appel réussi");
	}

	@Override
	public String blablaRemote() {
		return "ok";
	}

	@Override
	public String getNameFTP() {
		Properties props = new Properties();
		props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
		props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
		InitialContext ctx;
		try {
			ctx = new InitialContext(props);
			EjbRemoteM1 bean = (EjbRemoteM1) ctx
					.lookup("java:global/EARTest/EJBTestFTP/EJBMethode1!EjbRemoteM1");
			return bean.getName();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}

	@Override
	public String getNameHDD() {
		Properties props = new Properties();
		props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
		props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
		InitialContext ctx;
		try {
			ctx = new InitialContext(props);
			EjbRemoteM2 bean = (EjbRemoteM2) ctx
					.lookup("java:global/EARTest/EJBTestHDD/EJBMethod2!EjbRemoteM2");
			return bean.getName();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}

	@Override
	public String methodeTestLocal() {
		// TODO Auto-generated method stub
		return null;
	}

}
