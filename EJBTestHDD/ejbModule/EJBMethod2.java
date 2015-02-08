import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;


@Stateful

public class EJBMethod2 implements EjbRemoteM2{
	
	private String monAttribut;
	
	
	public EJBMethod2(){
		System.out.println("coucou");	
	}
	
	public void maMethode() {
		System.out.println("appel réussi");
	}

	@Override
	public String getName() {
		return "la mthode 2";
	}

	
	
}
