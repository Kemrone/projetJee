package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "Achat")
public class Achat  implements Serializable {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	    Long id;

	    @ManyToOne 
	    @JoinColumn(name = "uId")
	    Utilisateur utilisateur;

	    @ManyToOne
	    @JoinColumn(name = "bId")
	    Billet billet;

	    Date date;
	    Integer quantite;
	    
	    
	    
		public Achat() {
			super();
		}

		public Achat(Long id, Utilisateur utilisateur, Billet billet, Date date, Integer quantite) {
			super();
			this.id = id;
			this.utilisateur = utilisateur;
			this.billet = billet;
			this.date = date;
			this.quantite = quantite;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Utilisateur getUtilisateur() {
			return utilisateur;
		}

		public void setUtilisateur(Utilisateur utilisateur) {
			this.utilisateur = utilisateur;
		}

		public Billet getBillet() {
			return billet;
		}

		public void setBillet(Billet billet) {
			this.billet = billet;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public Integer getQuantite() {
			return quantite;
		}

		public void setQuantite(Integer quantite) {
			this.quantite = quantite;
		}
	
	    
	    
}
