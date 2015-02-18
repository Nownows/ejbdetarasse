package responsable;

import javax.ejb.Remote;

import model.Lecteur;
import model.Redacteur;
import model.ResponsableFacturation;

@Remote
public interface GestResponsableInterface {
	public void insertResponsable(ResponsableFacturation l);
	public ResponsableFacturation authentification(String mail, String pass);
}
