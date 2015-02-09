package lecteur;

import javax.ejb.Remote;

import model.Lecteur;

@Remote
public interface GestLecteurInterface {
	public void insertLecteur(Lecteur l);
	public Lecteur authentification(String mail, String pass);
}
