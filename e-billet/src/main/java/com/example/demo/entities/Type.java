package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Type")
public class Type implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long tId;
	private String tName;
	@OneToMany(mappedBy="type")
	private Collection<Evenement> evenements;
	
	public Type() {
		
	}
	
	public Type(Long tId, String tName, Collection<Evenement> evenements) {
		super();
		this.tId = tId;
		this.tName = tName;
		this.evenements = evenements;
	}
	
	public Type( String tName) {
		super();
		this.tName = tName;
	}
	
	public Type( String tName, Collection<Evenement> evenements) {
		super();
		this.tName = tName;
		this.evenements = evenements;
	}

	public Long gettId() {
		return tId;
	}

	public void settId(Long tId) {
		this.tId = tId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public Collection<Evenement> getEvenements() {
		return evenements;
	}

	public void setEvenements(Collection<Evenement> evenements) {
		this.evenements = evenements;
	}

	

	
	

}
