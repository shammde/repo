package com.sham.cmt.cart.ent;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author mehtesham
 *
 */

@Entity
@Table(name = "CartTable")
public class Cart {
	
	@Id
	@Column(name = "cartId")
	String ID;
	@Column(name = "CartName")
	String name;
	@OneToMany
	List<ItemLine> itemLines;
	
	public Cart() {
		this.name = "Unknown";
	}
	
	public Cart(String name) {
		this.name = name;
	}
	
	public Cart(String ID, String name) {
		this.ID = ID;
		this.name = name;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<ItemLine> getItemLine() {
		return itemLines;
	}

	public void setItemLine(List<ItemLine> itemLines) {
		this.itemLines = itemLines;
	}
	
	public void addItemLine(ItemLine itemLine) {
		if(itemLines == null) itemLines = new ArrayList<ItemLine>();
		itemLines.add(itemLine);
	}
}
