package com.hibernate.example.entity;

import jakarta.persistence.Entity;

@Entity
public class Customer extends Person{
	
	private String acctType;

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	
	

}
