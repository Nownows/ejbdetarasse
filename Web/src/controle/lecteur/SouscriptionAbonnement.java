package controle.lecteur;

import java.util.Map;

import model.Article;
import model.Lecteur;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import controle.ejb.EJBContext;

public class SouscriptionAbonnement extends ActionSupport implements SessionAware{
	
	Map<String, Object> session;
	
	
	
	@Override
	public String execute() throws Exception {
	
		System.out.println("souscription abonnement");
	
	Lecteur lecteur = (Lecteur) ActionContext.getContext().getSession().get("lecteur");
	lecteur = EJBContext.getEJBLecteur().updateAbonnement(lecteur);
	System.out.println("achat d'article");
	session.put("lecteur", lecteur);	
		return SUCCESS;
	}

	
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;	
	}

}
