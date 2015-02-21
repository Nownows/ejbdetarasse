package controle.lecteur;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.apache.struts2.interceptor.SessionAware;

import model.Article;
import model.Categorie;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CategorieManager  extends ActionSupport implements SessionAware{
	private int idCategorie;
	Map<String, Object> session;

	
	
	
	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	@Override
	public String execute() throws Exception {
		
	String[] idC =  (String[]) ActionContext.getContext().getParameters().get("idCategorie");
	List<Categorie> categories = (List<Categorie>) ActionContext.getContext().getSession().get("categories");
	List<Article> articles = new ArrayList<Article>();
	
	if(idC!=null){
		idCategorie = Integer.parseInt(idC[0]);
		for(Categorie c: categories){
			if(c.getId() == idCategorie){
				System.out.println("jai trouvé categ");
				articles = c.getLesArticles();
			}
		}
		if(articles.size()==0){
			System.out.println("lol");
		}
		session.put("articles", articles);
		session.put("idCategorie", idCategorie);
	}else{
		System.out.println("haha");
	}
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;	
	}
}
