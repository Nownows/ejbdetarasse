package controle.lecteur;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class DeconnexionManager extends ActionSupport implements SessionAware{
	Map<String, Object> session;
	
	
	@Override
	public String execute() throws Exception {
		session.remove("lecteur");
		session.remove("redacteur");
		session.remove("journaliste");
		
		return SUCCESS;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

}
