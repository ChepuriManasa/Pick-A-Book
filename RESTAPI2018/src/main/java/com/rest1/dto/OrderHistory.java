package com.rest1.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrderHistory {
	@Id @GeneratedValue
	private int serialNo;
	private int quantity;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@OneToOne
	@JoinColumn(name="bookId")
	private Books books;
	
	public OrderHistory(int serialNo, int quantity, Books books, Orders orders) {
		super();
		this.serialNo = serialNo;
		this.quantity = quantity;
		this.books = books;
		this.orders = orders;
	}
	@ManyToOne
	@JoinColumn(name="orderId")
	private Orders orders;
	
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	
	
	public OrderHistory() {
		
	}
}
