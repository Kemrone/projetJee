package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "Lieu")
public class Lieu implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long lId;
	private String lName, lAddress;
	@OneToMany(mappedBy="lieu")
    @NotFound(action = NotFoundAction.IGNORE)
	private Collection<Acceuil> acceuil;
	
	
	public Lieu(Long lId, String lName, String lAddress, Collection<Acceuil> acceuil) {
		super();
		this.lId = lId;
		this.lName = lName;
		this.lAddress = lAddress;
		this.acceuil = acceuil;
	}
	
	public Lieu( String lName, String lAddress, Collection<Acceuil> acceuil) {
		super();
		this.lName = lName;
		this.lAddress = lAddress;
		this.acceuil = acceuil;
	}

	public Lieu( String lName, String lAddress) {
		super();
		this.lName = lName;
		this.lAddress = lAddress;
		
	}
	
	public Collection<Acceuil> getAcceuil() {
		return acceuil;
	}

	public void setAcceuil(Collection<Acceuil> acceuil) {
		this.acceuil = acceuil;
	}

	public Lieu() {
		
	}

	public Long getlId() {
		return lId;
	}

	public void setlId(Long lId) {
		this.lId = lId;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getlAddress() {
		return lAddress;
	}

	public void setlAddress(String lAddress) {
		this.lAddress = lAddress;
	}

	

}
