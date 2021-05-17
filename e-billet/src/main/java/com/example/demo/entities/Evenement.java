package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "Evenement")
public class Evenement implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long eId;
	private String eName;
	@ManyToOne
	@JoinColumn(name="tId" )
	private Type type;
	@OneToMany(mappedBy="evenement",fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	private Collection<Acceuil> acceuil;
	@OneToMany(mappedBy="evenement")
	private Collection<Billet> billet;
	
	
	
	public Evenement() {
		
	}

	public Evenement(Long eId, String eName, Type type, Collection<Acceuil> acceuil,Collection<Billet> billet) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.type = type;
		this.acceuil = acceuil;
	}
	
	public Evenement( String eName, Type type) {
		super();
		this.eName = eName;
		this.type = type;
	}
	
	public Evenement(String eName, Type type, Collection<Acceuil> acceuil, Collection<Billet> billet) {
		super();
		this.eName = eName;
		this.type = type;
		this.acceuil = acceuil;
	}

	
	
	
	public Collection<Billet> getBillet() {
		return billet;
	}

	public void setBillet(Collection<Billet> billet) {
		this.billet = billet;
	}

	public Collection<Acceuil> getAcceuil() {
		return acceuil;
	}

	public void setAcceuil(Collection<Acceuil> acceuil) {
		this.acceuil = acceuil;
	}

	

	public Long geteId() {
		return eId;
	}

	public void seteId(Long eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	
}
