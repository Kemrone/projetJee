package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.entities.Utilisateur;

@Entity
@Table(name = "Role")
public class Role implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long rId;
	private String rName;
	@OneToMany(mappedBy="role",fetch = FetchType.LAZY)
	private Collection<Utilisateur> utilisateurs;
	
	public Role() {
		
	}

	public Long getrId() {
		return rId;
	}

	public void setrId(Long rId) {
		this.rId = rId;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public Collection<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Role(Long rId, String rName, Collection<Utilisateur> utilisateurs) {
		super();
		this.rId = rId;
		this.rName = rName;
		this.utilisateurs = utilisateurs;
	}

	

	
	

}
