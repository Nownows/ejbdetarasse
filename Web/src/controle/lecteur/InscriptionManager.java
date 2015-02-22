package controle.lecteur;

import java.util.Map;

import model.Article;
import model.Journaliste;
import model.Lecteur;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import controle.ejb.EJBContext;



public class InscriptionManager  extends ActionSupport implements SessionAware{

	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String pays;
	
	Map<String, Object> session;
	
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
	
	
	@Override
	public String execute() throws Exception {
		if(nom.equals("") || prenom.equals("") || email.equals("") || password.equals("")){
			return INPUT;
		}
		Lecteur l = new Lecteur();
		l.setNom(nom);
		l.setPrenom(prenom);
		l.setEmail(email);
		l.setPassword(password);
		l.setPays(pays);
		l.setStatus(0);
		l.setDateDebut(0);
		l.setDateFin(0);
		if(EJBContext.getEJBLecteur()!=null){
			Lecteur lInscrit = EJBContext.getEJBLecteur().insertLecteur(l);
			session.put("lecteur", lInscrit);
		}
		return SUCCESS;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;	
	}

	
	
}
