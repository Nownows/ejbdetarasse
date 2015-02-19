//package model;
//
//import java.io.Serializable;
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.IdClass;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity  @IdClass(ArticleLecteurID.class)
//@Table(name = "article_lecteur")
//public class ArticleLecteur implements Serializable{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 7817055801241931218L;
//
//	@Id
//	@ManyToOne
//    @JoinColumn(name = "idArticle")
//    private Article idArticle;
//
//	@Id
//    @ManyToOne
//    @JoinColumn(name = "idLecteur")
//    private Lecteur idLecteur;
//	
//	@Column(name = "dateAchat")
//	private Date dateAchat;
//
//	public ArticleLecteur(){
//		
//	}
//	
//	
//
//	public Article getIdArticle() {
//		return idArticle;
//	}
//
//
//
//	public void setIdArticle(Article idArticle) {
//		this.idArticle = idArticle;
//	}
//
//
//
//	public Lecteur getIdLecteur() {
//		return idLecteur;
//	}
//
//
//
//	public void setIdLecteur(Lecteur idLecteur) {
//		this.idLecteur = idLecteur;
//	}
//
//
//
//	public Date getDateAchat() {
//		return dateAchat;
//	}
//
//	public void setDateAchat(Date dateAchat) {
//		this.dateAchat = dateAchat;
//	}
//	
//	
//	
//	
//}
