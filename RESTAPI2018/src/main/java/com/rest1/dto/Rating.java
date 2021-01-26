
package com.rest1.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Rating {
	@Id @GeneratedValue
	private int serialNo;
	
	@OneToOne
	@JoinColumn(name="bookId")
	private Books books;
	
	/*@ManyToOne
	@JoinColumn(name="custId")
	private Customer customer;*/
	
	
	int rating;
	
	
	public Rating() {
		
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

	public Rating(int serialNo, Books books, int rating) {
		super();
		this.serialNo = serialNo;
		this.books = books;
		this.rating = rating;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	


	


	
	
	
}
