package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Restriction implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long restrictionId;
	private String nom;
	@OneToMany(mappedBy="restriction")
	private Collection<Requiert> requiert;
	
	
	
	public Restriction() {
		super();
	}

	
	
	public Restriction(Long restrictionId, String nom, Collection<Requiert> requiert) {
		super();
		this.restrictionId = restrictionId;
		this.nom = nom;
		this.requiert = requiert;
	}



	public Restriction(Long  restrictionId, String nom) {
		super();
		this. restrictionId =  restrictionId;
		this.nom = nom;
	}

	public Restriction(String nom) {
		super();
		this.nom = nom;
	}

	public Long getRestrictionId() {
		return  restrictionId;
	}

	public void setRestrictionId(Long  restrictionId) {
		this.restrictionId =  restrictionId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public Collection<Requiert> getRequiert() {
		return requiert;
	}


	public void setRequiert(Collection<Requiert> requiert) {
		this.requiert = requiert;
	}
	
	

}
