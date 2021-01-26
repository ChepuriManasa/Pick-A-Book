package com.rest1;

import java.awt.print.Book;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.rest1.dto.Address;
import com.rest1.dto.Books;
import com.rest1.dto.Customer;

import com.ts1.dao.BooksDAO;
import com.ts1.dao.CustomerDAO;

public class MyResource2 {
	@Path("regCustomer")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    public String regCustomer(Customer customer) {
		CustomerDAO custDao = new CustomerDAO();
		custDao.register(customer);
    	return "Registration Successful...";
    }
	
	@Path("updateCustomer")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateCustomer(Customer customer) {
		CustomerDAO cusDao = new CustomerDAO();
		cusDao.updateCustomer(customer);
		return "updated successful...";
	}

	@Path("sellBook")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String sellBook(Books book) {
		BooksDAO booksDao = new BooksDAO();
		booksDao.sellBook(book);
		return "Success";
		
	}
	
	@Path("deleteBookAddedByCustomer/{bookId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteBookaddedByCustomer(@PathParam("bookId") int bookId){
		CustomerDAO custDao = new CustomerDAO();
		
		//custDao.deleteBookaddedByCustomer(bookId);
		
	}	
	
	@Path("placeOrder/{bookId}/{custId}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void placeOrder(@PathParam("bookId") int bookId, @PathParam("loginId") String loginId){
		CustomerDAO custDao = new CustomerDAO();
		Customer c = new Customer();
		Book book = new Book();
		
		//Order order = new Order();
		//order.se
		//custDao.buyBook(bookId, custId);
		
	}	
	
}
