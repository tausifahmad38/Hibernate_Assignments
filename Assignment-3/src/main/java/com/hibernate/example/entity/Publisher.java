package com.hibernate.example.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Publisher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "publisher_id")
	private Integer publisherId;
	private String name;
	private String address;
	@OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
//	@JoinColumn(name = "book_id")
	private Set<Book> bookList = new HashSet<Book>(0); ;
	
	
	public Integer getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public Set<Book> getBookList() {
		return bookList;
	}
	public void setBookList(Set<Book> bookList) {
		this.bookList = bookList;
	}
	@Override
	public String toString() {
		return "Publisher [publisherId=" + publisherId + ", name=" + name + ", address=" + address + ", bookList="
				+ bookList + "]";
	}
	
	
	

}
