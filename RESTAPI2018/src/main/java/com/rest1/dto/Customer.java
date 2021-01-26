package com.rest1.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Customer {
	@Id@GeneratedValue
	private int custId;
	private String custName;
	private String email;
	@Embedded
	private Address address;
	private String mobileNo;
	private String loginId;
	private String password;
	
	public Customer() {
		
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer(int custId, String custName, String email, Address address, String mobileNo, String loginId,
			String password) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.email = email;
		this.address = address;
		this.mobileNo = mobileNo;
		this.loginId = loginId;
		this.password = password;
	}

	/*public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}
	public Customer(int custId, String custName, String email, Address address, String mobileNo, String loginId,
			String password, List<Books> books, List<Orders> orders, List<Cart> cart) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.email = email;
		this.address = address;
		this.mobileNo = mobileNo;
		this.loginId = loginId;
		this.password = password;
		this.books = books;
		this.orders = orders;
		this.cart = cart;
	}

	
	
	/*@OneToMany(mappedBy="customer",fetch = FetchType.LAZY)
	private List<Books> books = new ArrayList<Books>();

	@OneToMany(mappedBy="customer",fetch = FetchType.LAZY)
	private List<Orders> orders = new ArrayList<Orders>();
	
	@OneToMany(mappedBy="customer",fetch = FetchType.LAZY)
	private List<Cart> cart = new ArrayList<Cart>();*/


	
	
}
