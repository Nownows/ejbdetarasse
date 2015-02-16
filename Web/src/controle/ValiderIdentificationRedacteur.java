/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.Map;
import java.util.Properties;

import javax.naming.InitialContext;

import lecteur.GestLecteurInterface;
import model.Lecteur;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ValiderIdentificationRedacteur extends ActionSupport implements SessionAware{
    
    private String identifiant;
    private String motdepasse;
    Map<String, Object> session;

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }


    @Override
	public String execute() throws Exception {
		return SUCCESS;
    }

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;	
	}
}