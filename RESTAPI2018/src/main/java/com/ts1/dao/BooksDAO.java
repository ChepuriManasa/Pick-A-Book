package com.ts1.dao;

import org.hibernate.SessionFactory;
import com.rest1.dto.Books;
import com.ts1.db.HibernateTemplate;

public class BooksDAO {
	private SessionFactory factory = null;
	public int sellBook(Books book) {
		System.out.println("hiii....");
		//java.util.Date utilDate = new java.sql.Date(book.getPublishedDate().getTime()); 
		return HibernateTemplate.addObject(book);
	}
	public static Books getBook(int custId, String bookName) {
		return (Books) HibernateTemplate.getObjectById(custId, bookName);
	}
	
	
}

