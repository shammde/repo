package com.sham.cmt.cart.ent;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tax {

	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
