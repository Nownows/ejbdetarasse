package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@IdClass(ArticleAchatId.class)
@Table(name = "article_achat")
public class ArticleAchat {
	@Id
	@JoinColumn(name="lecteur")
	@ManyToOne(targetEntity=Lecteur.class,fetch=FetchType.EAGER)
	private Lecteur l;
	@Id
	@JoinColumn(name="article")
	@ManyToOne(targetEntity=Article.class,fetch=FetchType.EAGER)
	private Article a;
	@Column(name="date", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date d;
	public Lecteur getL() {
		return l;
	}
	public void setL(Lecteur l) {
		this.l = l;
	}
	public Article getA() {
		return a;
	}
	public void setA(Article a) {
		this.a = a;
	}
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
	
	
}
