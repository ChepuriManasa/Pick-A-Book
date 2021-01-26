package com.rest1.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.rest1.dto.Customer;

@Entity
public class Cart {
	@Id @GeneratedValue
	private int cartId;
	private double price;
	private int cartQuantity;
	
	
	@ManyToOne
	@JoinColumn(name="custId")
	private Customer customer;
	
	
	@ManyToOne
	@JoinColumn(name="bookId")
	private Books books;
	
	

	public Cart() {
		
	}


	public Cart(int cartId, double price, int cartQuantity, Customer customer, Books books) {
		super();
		this.cartId = cartId;
		this.price = price;
		this.cartQuantity = cartQuantity;
		this.customer = customer;
		this.books = books;
	}


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getCartQuantity() {
		return cartQuantity;
	}


	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Books getBooks() {
		return books;
	}


	public void setBooks(Books books) {
		this.books = books;
	}


	/*public Orders getOrders() {
		return orders;
	}


	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	
	@ManyToOne
	private Orders orders;
	
	public Cart(int cartId, double price, int cartQuantity, Customer customer, Books books, Orders orders) {
		super();
		this.cartId = cartId;
		this.price = price;
		this.cartQuantity = cartQuantity;
		this.customer = customer;
		this.books = books;
		this.orders = orders;
	}

	
	*/
	
	
}
