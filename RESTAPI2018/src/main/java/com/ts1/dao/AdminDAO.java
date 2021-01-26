package com.ts1.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rest1.dto.Books;
import com.rest1.dto.Customer;
import com.rest1.dto.Orders;
import com.ts1.db.HibernateTemplate;

public class AdminDAO {
	private SessionFactory factory = null;
	
	public int addBookByAdmin(Books book) {
		return HibernateTemplate.addObject(book);
	}

    public Books getBookAddedByAdmin(int bookId) {
    	return (Books) HibernateTemplate.getObjectById(bookId);
    }
  /*  public int deleteBookAddedByAdmin(String bookName) {
		System.out.println(HibernateTemplate.getObjectById(bookName));
		Books b = (Books) HibernateTemplate.getObjectById(bookName);
		return HibernateTemplate.deleteBookAddedByCustomer(b);
	}*/
	
    public int deleteBookAddedByAdmin(int bookId) {
    	return HibernateTemplate.deleteObject(Books.class, bookId);
    }
    public List<Books> viewAllBooks() {
    	List<Books> list = HibernateTemplate.getObjectListByQuery();
    	System.out.println(list);
    	return list;
    	/*Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Query q1 = session.createQuery("from Books");
		List<Books> bookList = q1.list();
		//session.close();
		return bookList;*/

   
    }
    public List<Customer> viewAllCustomers() {
    	return HibernateTemplate.getCustomerListByQuery();
    }
    public List<Orders> viewAllOrders() {
    	return HibernateTemplate.getOrderListByQuery();
    }
    
    public void deliverOrder(int orderId) {
    	Orders order = new Orders();
    	order = (Orders) HibernateTemplate.getOrderById(orderId);
    	
    }
}
	

