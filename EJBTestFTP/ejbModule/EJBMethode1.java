import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;


@Stateful

public class EJBMethode1 implements EjbRemoteM1{
	
	private String monAttribut;
	
	public void maMethode() {
		System.out.println("appel r�ussi");
	}

	@Override
	public String getName() {
		return "la methode 1";
	}


	
	
}
