package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "journaliste")
@DiscriminatorValue( "Journaliste")
public class Journaliste extends Employe implements Serializable {
	private static final long serialVersionUID = 275557556245723911L;
	

	
	
}
