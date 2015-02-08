package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "note")
public class Note implements Serializable {
	private static final long serialVersionUID = -1900639718165098050L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	@Column(name="note")
	private float note;
	@ManyToOne(targetEntity=Article.class)
	@JoinColumn(name="article")
	private Article article;
	
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Note(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getNote() {
		return note;
	}

	public void setNote(float note) {
		this.note = note;
	}
	
	
}
