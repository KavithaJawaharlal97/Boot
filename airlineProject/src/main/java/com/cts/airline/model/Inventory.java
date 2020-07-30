package com.cts.airline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory {

	@Id
	@GeneratedValue
	private int invId;
	private int count;
	
	public Inventory() {
		// TODO Auto-generated constructor stub
	}
	
	public Inventory( int count) {
	
		this.count = count;
	}

	public int getInvId() {
		return invId;
	}

	public void setInvId(int invId) {
		this.invId = invId;
	}

	public int getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "Inventory [invId=" + invId + ", count=" + count + "]";
	}
	
}