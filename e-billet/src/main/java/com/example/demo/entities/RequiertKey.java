package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RequiertKey  implements Serializable {

	    @Column(name = "bId")
	    private Long bId;

	    @Column(name = " restrictionId")
	    private Long restrictionId;

	    
	    
		public RequiertKey() {
			super();
		}



		public RequiertKey(Long bId, Long restrictionId) {
			super();
			this.bId = bId;
			this.restrictionId = restrictionId;
		}



		public Long getbId() {
			return bId;
		}



		public void setbId(Long bId) {
			this.bId = bId;
		}



		public Long getRestrictionId() {
			return restrictionId;
		}



		public void setRestrictionId(Long restrictionId) {
			this.restrictionId = restrictionId;
		}

	
		
}
