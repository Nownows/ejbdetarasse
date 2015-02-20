package employe;

import javax.ejb.Remote;

import model.Employe;

@Remote
public interface GestEmployesInterface {
	public Employe authentification(String mail, String pass);
	
}
