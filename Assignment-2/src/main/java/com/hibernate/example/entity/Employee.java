package com.hibernate.example.entity;

import jakarta.persistence.Entity;

@Entity
public class Employee extends Person{
	
	private String dept;

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	

}
