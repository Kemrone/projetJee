package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Billet")
public class Billet implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long bId;
	private String bCritere;
	private Integer stock;
	private Double bTarif;
	@ManyToOne
	@JoinColumn(name="eId" )
	private Evenement evenement;
	@OneToMany(mappedBy="billet")
	private Collection<Achat> achats;
	@OneToMany(mappedBy="billet")
	private Collection<Requiert> requiert;
	
	public Billet() {
		
	}
	
	

	public Billet(String bCritere, Integer stock, Double bTarif, Evenement evenement,
			 Collection<Achat> achats) {
		super();
		this.bCritere = bCritere;
		this.stock = stock;
		this.bTarif = bTarif;
		this.evenement = evenement;
		this.achats = achats;
	}

	

	public Billet(Long bId, String bCritere, Integer stock, Double bTarif, Evenement evenement,
			Collection<Achat> achats, Collection<Requiert> requiert) {
		super();
		this.bId = bId;
		this.bCritere = bCritere;
		this.stock = stock;
		this.bTarif = bTarif;
		this.evenement = evenement;
		this.achats = achats;
		this.requiert = requiert;
	}



	public Billet(Long bId, String bCritere, Double bTarif,  Integer stock, Evenement evenement) {
		super();
		this.bId = bId;
		this.bCritere = bCritere;
		this.bTarif = bTarif;
		this.stock = stock;
		this.evenement = evenement;
	}
	
	public Billet(String bCritere, Double bTarif, Integer stock, Evenement evenement) {
		super();
		this.bCritere = bCritere;
		this.bTarif = bTarif;
		this.stock = stock;
		this.evenement = evenement;
		
	}

	public Long getbId() {
		return bId;
	}

	public void setbId(Long bId) {
		this.bId = bId;
	}

	public String getbCritere() {
		return bCritere;
	}

	public void setbCritere(String bCritere) {
		this.bCritere = bCritere;
	}

	
	
	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public void setbTarif(Double bTarif) {
		this.bTarif = bTarif;
	}
	
	public Double getbTarif() {
		return bTarif;
	}


	public Evenement getEvenement() {
		return evenement;
	}

	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}

	

	public Collection<Achat> getAchats() {
		return achats;
	}



	public void setAchats(Collection<Achat> achats) {
		this.achats = achats;
	}



	public Collection<Requiert> getRequiert() {
		return requiert;
	}



	public void setRequiert(Collection<Requiert> requiert) {
		this.requiert = requiert;
	}

	

	
	
	
}
