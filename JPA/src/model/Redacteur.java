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
@Table(name = "redacteur")
@DiscriminatorValue( "Redacteur")
public class Redacteur extends Employe implements Serializable {

	private static final long serialVersionUID = -5897640158709261557L;
		
	
}
