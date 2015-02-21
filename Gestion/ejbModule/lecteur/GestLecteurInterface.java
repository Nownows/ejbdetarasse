package lecteur;

import javax.ejb.Remote;

import model.Lecteur;

@Remote
public interface GestLecteurInterface {
	public Lecteur insertLecteur(Lecteur l);
	public Lecteur authentification(String mail, String pass);
	public void acheterArticle(int idLecteur, int idArticle);
	public Lecteur updateAbonnement(Lecteur l);
}
