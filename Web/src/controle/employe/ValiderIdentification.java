/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.employe;

import java.util.Map;
import java.util.Properties;

import javax.naming.InitialContext;

import journaliste.GestJournalistesInterface;
import lecteur.GestLecteurInterface;
import model.Employe;
import model.Journaliste;
import model.Lecteur;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import employe.GestEmployesInterface;

public class ValiderIdentification extends ActionSupport implements SessionAware{
    
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
    	System.out.println("lul");
    	Properties props = new Properties();
		props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
		props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
		InitialContext ctx;
		try {
			ctx = new InitialContext(props);
			GestEmployesInterface bean = (GestEmployesInterface) ctx
					.lookup("java:global/EARTest/Gestion/GestionEmployes!employe.GestEmployesInterface");
			Employe ret = bean.authentification(identifiant, motdepasse);
			if (null == ret){
				return INPUT;
			}
			else {
				session.put("employe", ret);
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        return INPUT;
    }

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;	
	}
}