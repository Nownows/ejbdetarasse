package redacteur;

import javax.ejb.Remote;

import model.Redacteur;

@Remote
public interface GestRedacteurInterface {
	public void insertRedacteur(Redacteur l);
	public Redacteur authentification(String mail, String pass);
}
