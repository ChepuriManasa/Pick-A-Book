package com.rest1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;


import com.rest1.dto.Address;
import com.rest1.dto.Books;
import com.rest1.dto.Cart;

import com.rest1.dto.Customer;
import com.rest1.dto.OrderHistory;
import com.rest1.dto.Orders;
import com.rest1.dto.Rating;
import com.rest1.dto.Reviews;
import com.ts1.dao.AdminDAO;
import com.ts1.dao.BooksDAO;
import com.ts1.dao.CustomerDAO;
import com.ts1.dao.SendMail;
import com.ts1.db.HibernateTemplate;
@Path("myresource1")
public class MyResource1 {
	
	
	
	@Path("getMyWallet/{custId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrderHistory> getMyWallet(@PathParam("custId") int custId){
		CustomerDAO custDao = new CustomerDAO();
	    return custDao.getMyWallet(custId);
		
	
			
	}
	
	@Path("getMyWallet1/{custId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public double getMyWallet1(@PathParam("custId") int custId){
		CustomerDAO custDao = new CustomerDAO();
		System.out.println(HibernateTemplate.getMyWallet1(custId));
	    return HibernateTemplate.getMyWallet1(custId);	
	
			
	}
	
	@Path("getCustId/{orderIdId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public int getCustId(@PathParam("orderId") int orderId){
		return HibernateTemplate.getCustId(orderId).getCustId();
		
			
	}


	@Path("getAllLoginIds")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getAllLoginIds(){
		return HibernateTemplate.getAllLoginIds();
	}


	@Path("addReview")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String addReview(Reviews review) {
		System.out.println("Data Recieved in review: " + review.getBooks());
		HibernateTemplate.addObject(review);
		return null;
	}

	@Path("getReviewsByBookId/{bookId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reviews> getReviewsByBookId(@PathParam("bookId") int bookId){
		return HibernateTemplate.viewReviewsByBookId(bookId);
	}

	// customer methods
	@Path("regCustomer")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String regCustomer(Customer customer) {
		System.out.println("Data Recieved in Register : " + customer);
		CustomerDAO custDao = new CustomerDAO();
		custDao.register(customer);
		String msg = "Hello " + customer.getCustName() + "! Your Registration is Successful." ;
		String sub = "Pick-A-Book";
		SendMail.sendMail(customer.getEmail(), msg, sub);
		return null;
	}

	@Path("deliverOrders")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public void deliverOrders() {
		HibernateTemplate.deliverOrders();
	}


	@Path("updateCustomer")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateCustomer(Customer customer) {
		CustomerDAO cusDao = new CustomerDAO();
		cusDao.updateCustomer(customer);
		return "updated";
	}

	@Path("deleteMyBookAdded/{bookId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteMyBook(@PathParam("bookId") int bookId){
		System.out.println("delete..");
		CustomerDAO custDao = new CustomerDAO();
		custDao.deleteMyBook(bookId);
		return null;

	}	

	/*@Path("removeFromCart/{cartId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
	public String removeFromCart(@PathParam("cartId") int cartId){
		HibernateTemplate.removeFromCart(cartId);
		return null;
	}*/

	@Path("removeFromCart/{cartId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String removeFromCart(@PathParam("cartId") int cartId){
		Cart cart = new Cart();
		cart = HibernateTemplate.getCartItemById(cartId);
		HibernateTemplate.removeFromCart(cartId);

		System.out.println("cartItem deleted"+ cart);
		HibernateTemplate.changeBookCount(cart.getBooks().getBookId(), (cart.getCartQuantity()*-1));
		return null;
	} 



	@Path("addItemToCart/{custId}/{bookId}/{quantity}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public String addToCart(@PathParam("custId") int custId,@PathParam("bookId")  int bookId, @PathParam("quantity") int quantity) {
		Customer customer = new Customer();
		Books b = new Books();
		CustomerDAO custDao = new CustomerDAO();
		custDao.addItemToCart(custId, bookId, quantity);


		//HibernateTemplate.changeBookCount(bookId, quantity);

		return null;
	}

	@Path("addRating/{bookId}/{rating}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public String addToCart(@PathParam("bookId") int bookId, @PathParam("rating")  int rating) {
		Rating rate = new Rating();
		Books book = HibernateTemplate.getBookById(bookId);
		rate.setBooks(book);
		rate.setRating(rating);
		HibernateTemplate.addObject(rate);
		return null;
	}

	@Path("getAvgRating/{bookId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public double avgRating(@PathParam("bookId") int bookId) {
		double avgRating = HibernateTemplate.getAvgRating(bookId);
		System.out.println(avgRating);
		return avgRating;
	}


	@Path("placeOrder")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String placeOrder(int custId) {
		Customer customer = new Customer();
		Cart cart = new Cart();
		CustomerDAO custDao = new CustomerDAO();
		custDao.placeOrder(custId);
		return null;
	}
	
	@Path("searchBook/{bookName}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Books searchBook(@PathParam("bookName") String bookName) {
		return HibernateTemplate.searchBook(bookName);
	}

	@Path("customerLogin/{loginId}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Customer customerLogin(@PathParam("loginId") String loginId,@PathParam("password")  String password) {
		CustomerDAO custDao = new CustomerDAO();
		Customer c = custDao.customerLogin(loginId, password);
		if(c == null) {
			return null;
		}
		if(loginId.equals(c.getLoginId())) {
			return c;
		}
		else {

			return null;
		}


	}
	@Path("viewMyCart/{custId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cart> viewMyCart(@PathParam("custId") int custId) {
		System.out.println(custId);
		CustomerDAO custDao = new CustomerDAO();
		//List <CartItems> cartList = custDao.viewMyCart(custId);
		List<Cart> cartList = HibernateTemplate.viewMyCart(custId);
		System.out.println(cartList);
		return cartList;

	}

	@Path("viewMyOrders/{custId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrderHistory> viewMyOrders(@PathParam("custId") int custId) {
		System.out.println(custId);
		CustomerDAO custDao = new CustomerDAO();
		List<OrderHistory> orderList = HibernateTemplate.viewMyOrders(custId);
		System.out.println(orderList);
		return orderList;

	}

	@Path("viewCountOfOrders/{custId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrderHistory> viewCountOfOrders(@PathParam("custId") int custId) {
		System.out.println(custId);
		List list = HibernateTemplate.viewCountOfOrders(custId);
		System.out.println(list);
		return list;

	}


	@Path("viewMyBooks/{custId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Books> viewMyBooks(@PathParam("custId") int custId){
		CustomerDAO custDao = new CustomerDAO();
		List<Books> booksList = custDao.viewMyBooks(custId);	
		System.out.println(booksList);
		return booksList;		
	}

	@Path("getBookById/{bookId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Books getBookById(@PathParam("bookId") int bookId){
		CustomerDAO custDao = new CustomerDAO();
		Books book = custDao.getBookById(bookId);	
		System.out.println(book);
		return book;		
	}

	//Admin methods
	@Path("updateBook/{bookId}/{quantity}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void updateBook(@PathParam("bookId") int bookId, @PathParam("quantity") int quantity){
		Books book = HibernateTemplate.getBookById(bookId);
		book.setQuantityAdded(quantity);
		HibernateTemplate.updateObject(book);
	}


	@Path("deleteBookAddedByAdmin")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteBookAddedByAdmin(){
		Books b = new Books();
		int bookId=3;
		AdminDAO adminDao = new AdminDAO();
		adminDao.deleteBookAddedByAdmin(bookId);
		return null;

	}

	@Path("viewAllCustomers")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> viewAllCustomers(){
		AdminDAO adminDao = new AdminDAO();
		List<Customer> empList = adminDao.viewAllCustomers();	
		System.out.println(empList);
		return empList;	

	}
	@Path("viewAllBooks")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Books> viewAllBooks(){
		AdminDAO adminDao = new AdminDAO();
		List<Books> booksList = adminDao.viewAllBooks();	
		System.out.println(booksList);
		return booksList;		
	}

	@Path("getOldBooks/{custId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Books> getOldBooks(@PathParam("custId") int custId){
		System.out.println(custId);
		List<Books> booksList = HibernateTemplate.getOldBooks(custId);	
		System.out.println(booksList);
		return booksList;		
	}

	@Path("getNewBooks")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Books> getNewBooks(){
		List<Books> booksList = HibernateTemplate.getNewBooks();	
		System.out.println(booksList);
		return booksList;		
	}

	@Path("viewAllOrders")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Orders> viewAllOrders(){
		AdminDAO adminDao = new AdminDAO();
		List<Orders> orderList = adminDao.viewAllOrders();
		return orderList;

	}

	@Path("deliverOrder")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String deliverOrder(int orderId) {
		AdminDAO adminDao = new AdminDAO();
		adminDao.deliverOrder(1);
		return "order delivered";

	}
	@POST
	@Path("/uploadImage")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void uploadImage(@FormDataParam("Image") InputStream fileInputStream,
			@FormDataParam("Image") FormDataContentDisposition formDataContentDisposition,
			@FormDataParam("bookName") String bookName, @FormDataParam("description") String description, 
			@FormDataParam("price") double price 
			,@FormDataParam("bookStatus") String bookStatus, @FormDataParam("quantityAdded") int quantityAdded,
			@FormDataParam("category") String category, @FormDataParam("publishedDate") Date publishedDate,
			@FormDataParam("custId") int custId) throws IOException {
		int read = 0;
		byte [] bytes = new byte[1024];
		String path = this.getClass().getClassLoader().getResource("").getPath();
		String pathArr[] = path.split("/WEB-INF/classes");
		FileOutputStream out = new FileOutputStream(new File(pathArr[0] + "/image", formDataContentDisposition.getFileName()));
		while((read = fileInputStream.read(bytes)) != -1) {
			out.write(bytes,0,read);
		}
		out.flush();
		out.close();
		System.out.println("custId:"+ custId);

		CustomerDAO cdao= new CustomerDAO();
		Customer c = new Customer();

		c = cdao.viewCustomerProfile(custId);
		Books book = new Books();
		book.setBookName(bookName);
		book.setDescription(description);
		book.setPrice(price);
		book.setBookStatus(bookStatus);
		book.setCategory(category);
		book.setPublishedDate(publishedDate);
		book.setQuantityAdded(quantityAdded);
		book.setCustomer(c);
		book.setImageName(formDataContentDisposition.getFileName());

		AdminDAO adminDao = new AdminDAO();
		adminDao.addBookByAdmin(book);
	}

}




//CustomerDAO cdao= new CustomerDAO();
//int custId = cdao.getCustomerId(loginId);
//Customer c = new Customer();
//c.setCustId(custId);

//@PathParam("custId") int custId,@PathParam("bookId")  int bookId
//book.setCustomer(c);
/* @FormDataParam("loginId") String loginId
 * 
 *
 */
/*@Path("viewMyCart/{custId}")
@GET
@Produces(MediaType.APPLICATION_JSON)
public List<Cart> viewMyCart(@PathParam("custId") int custId) {
	System.out.println(custId);
	CustomerDAO custDao = new CustomerDAO();
	List <Cart> cartList = custDao.viewMyCart(custId);
	System.out.println(cartList);
	return cartList;

}*/