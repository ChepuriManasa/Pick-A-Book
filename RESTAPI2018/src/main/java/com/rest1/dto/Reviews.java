package com.rest1.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Reviews {
	@Id @GeneratedValue
	private int serialNo;
	
	@OneToOne
	@JoinColumn(name="bookId")
	private Books books;
	
	@ManyToOne
	@JoinColumn(name="custId")
	private Customer customer;
	
	
	String review;
	
	
	public Reviews() {
		super();
		
	}
	
	
	public Reviews(int serialNo, Books books, Customer customer, String review) {
		super();
		this.serialNo = serialNo;
		this.books = books;
		this.customer = customer;
		this.review = review;
	}


	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public Books getBooks() {
		return books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
