package com.example.demo.entities;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class AcceuilKey  implements Serializable {

	
	
    @Column(name = "lId")
    private Long lId;

    @Column(name = "eId")
    private Long eId;

	public AcceuilKey() {
		
	}
    
	public AcceuilKey(Long lId, Long eId) {
		super();
		this.lId = lId;
		this.eId = eId;
	}

	public Long getlId() {
		return lId;
	}

	public void setlId(Long lId) {
		this.lId = lId;
	}

	public Long geteId() {
		return eId;
	}

	public void seteId(Long eId) {
		this.eId = eId;
	}

	

}
