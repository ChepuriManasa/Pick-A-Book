package com.rest1.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Orders {
	@Id @GeneratedValue
	private int orderId;
	private String orderStatus;
	private int totalPrice;
	private Date dateOfOrder;
	
	@ManyToOne
	@JoinColumn(name="custId")
	private Customer customer;

	public Orders(int orderId, String orderStatus, int totalPrice, Date dateOfOrder, Customer customer) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.totalPrice = totalPrice;
		this.dateOfOrder = dateOfOrder;
		this.customer = customer;
	}

	public  Orders() {
		
	}

	public Orders(int orderId, String orderStatus, int totalPrice, Date dateOfOrder) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.totalPrice = totalPrice;
		this.dateOfOrder = dateOfOrder;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = (int) totalPrice;
	}

	public Date getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	/*@OneToMany(mappedBy="customer",fetch = FetchType.LAZY)
	private List<Cart> cart = new ArrayList<Cart>();*/
	

}
