package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "Requiert")
public class Requiert  implements Serializable {

 @EmbeddedId
    RequiertKey id = new RequiertKey();

    @ManyToOne
    @MapsId("bId")
    @JoinColumn(name = "bId")
    private Billet billet;

    @ManyToOne
    @MapsId("restrictionId")
    @JoinColumn(name = "restrictionId")
    private Restriction restriction;

	private String value;
    
	public Requiert() {
		super();
	}



	public Requiert(RequiertKey id, Billet billet, Restriction restriction,String value) {
		super();
		this.id = id;
		this.billet = billet;
		this.restriction = restriction;
		this.value =value;
	}



	public RequiertKey getId() {
		return id;
	}



	public void setId(RequiertKey id) {
		this.id = id;
	}



	public Billet getBillet() {
		return billet;
	}



	public void setBillet(Billet billet) {
		this.billet = billet;
	}



	public Restriction getRestriction() {
		return restriction;
	}



	public void setRestriction(Restriction restriction) {
		this.restriction = restriction;
	}



	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}
    
    
	
	
}
