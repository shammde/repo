package com.sham.cmt.cart.ent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemLine {
	
	@Id
	@Column(name = "ProductCode")
	String code;
	@Column(name = "ProductName")
	String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String toString() {
		return "Name " + name + " Code " + code;
	}

}
