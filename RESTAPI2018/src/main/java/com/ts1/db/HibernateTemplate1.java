package com.ts1.db;



import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rest1.dto.Address;
import com.rest1.dto.Books;
import com.rest1.dto.Cart;
import com.rest1.dto.Customer;


public class HibernateTemplate1 {
	public static void main(String[] args) {
		/*Customer c = new Customer();
		c.setCustId(1);
		c.setCustName("Manasa Ch");
		c.setEmail("abc@gmail.com");
		Address addr = new Address();
		addr.setCity("Hyderabad");
		addr.setState("Telangana");
		addr.setStreet("Bachupally");
		addr.setPincode(505301);
		addr.setHouseNo("3/7/116");
		c.setAddress(addr);
		c.setMobileNo("6303483432");
		c.setLoginId("manasa123");
		c.setPassword("123");
		
		Books b = new Books();
		b.setBookId(1);
		b.setBookName("Third Book");
		b.setBookStatus("new");
		b.setCategory("Novels");
		b.setPublishedDate(new java.util.Date());
		b.setPrice(500);
		b.setQuantityAdded(2);
		b.setRating(5);
		b.setCustomer(c);
		c.getBooks().add(b);
		
		Books b1 = new Books();
		b1.setBookId(1);
		b1.setBookName("Fourth Book");
		b1.setBookStatus("used");
		b1.setCategory("Novels");
		b1.setPublishedDate(new java.util.Date());
		b1.setPrice(600);
		b1.setQuantityAdded(2);
		b1.setRating(5);
		b1.setCustomer(c);
		
		c.getBooks().add(b1);
		
		SessionFactory s = new Configuration().configure().buildSessionFactory();
		Session session = s.openSession();
		session.beginTransaction();
		session.save(c);
		session.save(b);
		session.save(b1);
		session.getTransaction().commit();
		
		/*Books b = new Books();
		b.setBookId(1);
		b.setBookName("First Book");
		b.setBookStatus("new");
		b.setCategory("Novels");
		b.setPublishedDate(new java.util.Date());
		b.setPrice(500);
		b.setQuantityAdded(2);
		b.setRating(5);
		session = s.openSession();
		//session = s.openSession(); 
		session.beginTransaction();
		session.save(b);
		session.getTransaction().commit();
		
		Books b1 = new Books();
		b1.setBookId(1);
		b1.setBookName("Second Book");
		b1.setBookStatus("used");
		b1.setCategory("Novels");
		b1.setPublishedDate(new java.util.Date());
		b1.setPrice(600);
		b1.setQuantityAdded(2);
		b1.setRating(5);
		c.getBooks().add(b1);
		session = s.openSession();
		//session = s.openSession(); 
		session.beginTransaction();
		session.save(c);
		session.save(b1);	
		session.getTransaction().commit();*/
		/*SessionFactory s = new Configuration().configure().buildSessionFactory();
		Session session = s.openSession();
		session.beginTransaction();
		HibernateTemplate.deleteObject(Books.class, 1);
		session.getTransaction().commit();*/
	/*	Books b = new Books();
		Customer c = new Customer();
		Cart cart = new Cart();
        Order order = new Order();
		SessionFactory s = new Configuration().configure().buildSessionFactory();
		Session session = s.openSession();
		session.beginTransaction();
		/*order.setOrderStatus("Pending");
		order.setTotalPrice(500);*/
		/*c = (Customer) HibernateTemplate.getCustomerById(1);
		/*order.setCustomer(c);
		order.setDateOfOrder(new Date());*/
	/*	System.out.println(c);
		System.out.println(b);
		b =  (Books) HibernateTemplate.getObjectById(1);
		//c = (Customer) session.get(Customer.class, 2);*/ 
	    //b =  (Books) session.get(Books.class, 2);
	 /*   cart.setBooks(b);
	    cart.setCustomer(c);
	    session.save(cart);
	    session.save(order);
	    session.getTransaction().commit();*/
				
		
		
	}

}
