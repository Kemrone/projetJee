package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "Acceuil")
public class Acceuil implements Serializable{
	
	 @EmbeddedId
	    AcceuilKey id = new AcceuilKey();

	    @ManyToOne(fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @MapsId("eId")
	    @JoinColumn(name = "eId")
	   private Evenement evenement;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @MapsId("lId")
	    @JoinColumn(name = "lId")
	   private Lieu lieu;

	   private Date date;
	

	public Acceuil() {
			
		}

	public Acceuil(AcceuilKey id, Evenement evenement, Lieu lieu, Date date) {
			super();
			this.id = id;
			this.evenement = evenement;
			this.lieu = lieu;
			this.date = date;
		}



	public AcceuilKey getId() {
			return id;
		}



		public void setId(AcceuilKey id) {
			this.id = id;
		}



		public Evenement getEvenement() {
			return evenement;
		}



		public void setEvenement(Evenement evenement) {
			this.evenement = evenement;
		}



		public Lieu getLieu() {
			return lieu;
		}



		public void setLieu(Lieu lieu) {
			this.lieu = lieu;
		}



		public Date getDate() {
			return date;
		}



		public void setDate(Date date) {
			this.date = date;
		}




	
	

}
