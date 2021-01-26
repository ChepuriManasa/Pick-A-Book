package com.rest1.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Books {
	@Id@GeneratedValue
	private int bookId;
	private String bookName;
	private double price;
	private Date publishedDate;
	private String category;
	private int quantityAdded;
	private String bookStatus;
	private String description;
	private String imageName;
	
	@ManyToOne
	@JoinColumn(name="custId")
	private Customer customer;
	
	@OneToMany
	private List<Cart> cart = new ArrayList<Cart>();
	
	
	public List<Cart> getCart() {
		return cart;
	}
	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}
	
	public Books() {
		
	}
	
	public Books(int bookId, String bookName, int price, Date publishedDate, String category,
			int quantityAdded, String bookStatus, String description, String imageName, Customer customer,
			List<Cart> cart) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.price = price;
		this.publishedDate = publishedDate;
		this.category = category;
		this.quantityAdded = quantityAdded;
		this.bookStatus = bookStatus;
		this.description = description;
		this.imageName = imageName;
		this.customer = customer;
		this.cart = cart;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price2) {
		this.price = price2;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantityAdded() {
		return quantityAdded;
	}
	public void setQuantityAdded(int quantityAdded) {
		this.quantityAdded = quantityAdded;
	}
	public String getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookName=" + bookName + ", price=" + price + ", publishedDate=" + publishedDate + ", category=" + category + ", quantityAdded=" + quantityAdded
				+ ", bookStatus=" + bookStatus + ", customer=" + customer + ", cart=" + cart + "]";
	}
	
	

}
