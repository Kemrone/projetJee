package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Utilisateur")
public class Utilisateur implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long uId;
	private String uLastname, uFirstname, uMail, password;
	private Double solde;
	@ManyToOne
	@JoinColumn(name="rId" )
	private Role role;
	@OneToMany(mappedBy="utilisateur")
	private Collection<Achat> achats;
	
	public Utilisateur(Long uId, String uLastname, String uFirstname, String password, String uMail, Double solde, Role role,
			Collection<Achat> achats) {
		super();
		this.uId = uId;
		this.uLastname = uLastname;
		this.uFirstname = uFirstname;
		this.solde = solde;
		this.password = password;
		this.uMail = uMail;
		this.role = role;
		this.achats = achats;
	}
	
	public Utilisateur( String uLastname, String uFirstname, String password, String uMail, Double solde, Role role,
			Collection<Achat> achats) {
		super();
		this.uLastname = uLastname;
		this.uFirstname = uFirstname;
		this.solde = solde;
		this.password = password;
		this.uMail = uMail;
		this.role = role;
		this.achats = achats;
	}

	
	public Utilisateur( String uLastname, String uFirstname, String password, String uMail, Double solde, Role role)
			 {
		super();
		this.uLastname = uLastname;
		this.uFirstname = uFirstname;
		this.solde = solde;
		this.password = password;
		this.uMail = uMail;
		this.role = role;
		
	}


	public Utilisateur(){
		
	}

	public Long getuId() {
		return uId;
	}

	public void setuId(Long uId) {
		this.uId = uId;
	}

	public String getuLastname() {
		return uLastname;
	}

	public void setuLastname(String uLastname) {
		this.uLastname = uLastname;
	}

	public String getuFirstname() {
		return uFirstname;
	}

	public void setuFirstname(String uFirstname) {
		this.uFirstname = uFirstname;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getuMail() {
		return uMail;
	}

	public void setuMail(String uMail) {
		this.uMail = uMail;
	}

	

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Collection<Achat> getAchats() {
		return achats;
	}

	public void setAchats(Collection<Achat> achats) {
		this.achats = achats;
	}

	
	
	

}
