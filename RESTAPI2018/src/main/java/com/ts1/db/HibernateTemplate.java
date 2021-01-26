package com.ts1.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import com.rest1.dto.Books;
import com.rest1.dto.Cart;
import com.rest1.dto.Customer;
import com.rest1.dto.OrderHistory;
import com.rest1.dto.Orders;
import com.rest1.dto.Reviews;


public class HibernateTemplate {
	

	private static SessionFactory sessionFactory;
	
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public static int addObject(Object obj){
		System.out.println("Inside Template...");
		int result=0;
		Transaction tx=null;		
		try {
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			session.save(obj);
			tx.commit();
			result=1;		
		} catch (Exception e) {
			System.out.println("failure...");		
			tx.rollback();			
			e.printStackTrace();
		}		
		return result;
	}
	
	
	public static Object getObjectById(int bookId) {
		
	      String queryString = "from Books where bookId = :bookId";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setInteger("bookId", bookId);
		  Object queryResult = query.uniqueResult();
		  Books book = (Books)queryResult;
		  return book; 
	}	
	public static Object getCustomerById(int custId) {
		
	      String queryString = "from Customer where custId = :custId";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setInteger("custId", custId);
		  Object queryResult = query.uniqueResult();
		  Customer customer = (Customer)queryResult;
		  return customer; 
	}	
	
	
	
	public static int updateObject(Object obj)
	{
		int result=0;
		
		Transaction tx=null;
		Session session=sessionFactory.openSession();
		
		try {
			
			
			tx=session.beginTransaction();
			//sessionFactory.getCurrentSession().merge(obj);
			session.saveOrUpdate(obj);
			
			tx.commit();
			
			result=1;
			session.close();
			
		} catch (Exception e) {
		    
			tx.rollback();
			System.out.println("update failure...");
			e.printStackTrace();
			
		}
		
		return result;
	}
	
	public static int deleteObject(Class c,Serializable serializable)
	{
		int result=0;
		
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			Object obj=session.get(c,serializable);
			System.out.println(obj);
			System.out.println(serializable);
			
			session.delete(obj);
			
			tx.commit();
			
			result=1;
			
						
		} catch (Exception e) {
			
			e.printStackTrace();
			
			tx.rollback();
			
			System.out.println("delete failure...");
		}
		
		return result;
	}

	
	public static List<Customer> getCustomerListByQuery()
	{
		String query = "from Customer";
		return  sessionFactory.openSession().createQuery(query).list();
		
	}
	
	public static List<Books> getObjectListByQuery()
	{
		String query = "from Books";
		return sessionFactory.openSession().createQuery(query).list();
		
	}
	
	public static List<Orders> getOrderListByQuery()
	{
		String query = "from Orders";
		return sessionFactory.openSession().createQuery(query).list();
	}
	public static List<Cart> viewMyCart(int custId)
	{
		String queryS="from Cart where custId=:custId";
		return sessionFactory.openSession().createQuery(queryS).setParameter("custId", custId).list();	
		
	}
	public static List<Books> viewMyBooks(int custId)
	{
		String queryS="from Books where custId=:custId";
		return sessionFactory.openSession().createQuery(queryS).setParameter("custId", custId).list();	
		
	}
	
	public static List<Books> getOldBooks(int custId)
	{
		String queryS="from Books where custId !=:custId";
		return sessionFactory.openSession().createQuery(queryS).setParameter("custId", custId).list();	
		
	}
	
	public static List<Books> getNewBooks()
	{
		String bookStatus = "new";
		String queryS="from Books where bookStatus =:bookStatus";
		return sessionFactory.openSession().createQuery(queryS).setParameter("bookStatus", bookStatus).list();	
		
	}
	
	
	public static Customer getObjectByQuery(String query) {
		return (Customer) sessionFactory.openSession().createQuery(query);
	}

	
	public static int deleteBookAddedByCustomer(Object obj) {
		Session session=sessionFactory.openSession();
		Transaction tx = null;
		int result = 0;
		try {
			session.beginTransaction();
			session.delete(obj);
			session.getTransaction().commit();
			result=1;
		}catch (Exception e) {
			System.out.println("failure...");
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}
	
	public static Object getObjectById(int custId, String bookName) {
		  System.out.println("hiiii....");
	      SessionFactory s = new Configuration().configure().buildSessionFactory();
			Session session = s.openSession();
			session.beginTransaction();
			Query query = session.createQuery("from Books where custId = :custId and bookName = :bookName");
			query.setInteger("custId", custId);
			query.setString("bookName", bookName);
			//List books = query.list();
			Object queryResult = query.uniqueResult();
			Books book = (Books)queryResult;
			session.getTransaction().commit();
			session.close();
			return book;
	}
	
	//get book by id
	public static Books getBookById(int bookId) {
		    System.out.println("hiiii....");
	        SessionFactory s = new Configuration().configure().buildSessionFactory();
			Session session = s.openSession();
			session.beginTransaction();
			Query query = session.createQuery("from Books where bookId = :bookId");
			query.setInteger("bookId", bookId);
			Object queryResult = query.uniqueResult();
			Books book = (Books)queryResult;
			session.getTransaction().commit();
			session.close();
			return book;
	}
	
	//place order
	public static double placeOrder(int custId) {
		  System.out.println("hiiii....");
	      SessionFactory s = new Configuration().configure().buildSessionFactory();
			Session session = s.openSession();
			session.beginTransaction();
			Query query = session.createQuery("select sum(price) from Cart where custId = :custId");
			query.setInteger("custId", custId);
			Object queryResult = query.uniqueResult();
			double result = (double) queryResult;
			System.out.println(result);
			session.getTransaction().commit();
			session.close();
			return result;
	}
	
	public static Cart getCartItemById(int cartId) {
		String queryString = "from Cart where cartId = :cartId";
		Query query =  sessionFactory.openSession().createQuery(queryString);
		query.setInteger("cartId", cartId);
		Object queryResult = query.uniqueResult();
		Cart cart = (Cart)queryResult;
		return cart;
	}
	
	public static double getAvgRating(int bookId) {
		  System.out.println("hiiii....");
	      SessionFactory s = new Configuration().configure().buildSessionFactory();
			Session session = s.openSession();
			session.beginTransaction();
			Query query = session.createQuery("select avg(rating) from Rating where bookId = :bookId");
			query.setInteger("bookId", bookId);
			Object queryResult = query.uniqueResult();
			double result = (double) queryResult;
			System.out.println(result);
			session.getTransaction().commit();
			session.close();
			return result;
	}
	
	//customer login
	public static Customer customerLogin(String loginId, String password) {
		  System.out.println("hiiii....");
	      SessionFactory s = new Configuration().configure().buildSessionFactory();
			Session session = s.openSession();
			session.beginTransaction();
			Query query = session.createQuery("from Customer where loginId = :loginId and password = :password");
			query.setString("loginId", loginId);
			query.setString("password", password);
			Object queryResult = query.uniqueResult();
			Customer customer = (Customer)queryResult;
			session.getTransaction().commit();
			//session.close();
			return customer;
			
	}
	
	//deliver order
	public static Object getOrderById(int orderId) {
		  System.out.println("hiiii....");
	      SessionFactory s = new Configuration().configure().buildSessionFactory();
			Session session = s.openSession();
			session.beginTransaction();
			Query query = session.createQuery("from Orders where orderId = :orderId");
			query.setInteger("orderId", orderId);
			Object queryResult = query.uniqueResult();
			Orders order = (Orders)queryResult;
			order.setOrderStatus("Delivered");
			session.getTransaction().commit();
			session.close();
			return order;
	}
	//search book
	public static Books searchBook(String bookName) {
		  String queryString = "from Books where bookName = :bookName";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("bookName", bookName);
		  Object queryResult = query.uniqueResult();
		  Books book = (Books)queryResult;
		  return book;
	}
	
	public static Cart getFromCart(int bookId, int custId) {
		String queryString = "from Cart where bookId = :bookId and custId = :custId";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setInteger("bookId", bookId);
		query.setInteger("custId", custId);
		Object queryResult = query.uniqueResult();
		Cart cart = (Cart)queryResult;
		return cart;
	}
	//remove from cart
	public static void removeFromCart(int cartId) {
		deleteObject(Cart.class, cartId);
	}
	
	//delete from cart
	public static void deletefromCart(int custId) {
		
		SessionFactory s = new Configuration().configure().buildSessionFactory();
		Session session = s.openSession();
		session.beginTransaction();
		Query qry = session.createQuery("delete from Cart where custId=:custId");
		qry.setParameter("custId",custId);
		int res = qry.executeUpdate();

		System.out.println("deleted from cart"+res);
		session.getTransaction().commit();
	}
	
	/*public static void deliverOrders() {
		List<Orders> orders= new ArrayList<Orders>();
		System.out.println("in deliver orders");
		String queryString1 = "from Orders";
		Query query1 = sessionFactory.openSession().createQuery(queryString1);
		orders = query1.list();
		for(Orders order: orders) {
			if(order.getDateOfOrder().compareTo(new Date()) <= 0) {
				order.setOrderStatus("delivered");
				updateObject(order);
			}
		}
	}*/
	
	public static List<OrderHistory> viewMyOrders(int custId) {
		String queryString1 = "from OrderHistory where orderId in(select orderId from Orders where custId =:custId)";
		Query query1 = sessionFactory.openSession().createQuery(queryString1).setParameter("custId", custId);
		List<OrderHistory> orderHistory = new ArrayList<OrderHistory>();
		orderHistory = query1.list();
		return orderHistory;
	}
	public static List viewCountOfOrders(int custId) {
		String queryString1 = "select count(orderId), orderId from orderhistory where orderId in(select orderId from orders where custId =:custId) group by orderId";
		SQLQuery query1 = (SQLQuery) sessionFactory.openSession().createSQLQuery(queryString1).setParameter("custId", custId);
		return query1.list();
	}
	
	public static void deliverOrders() {
		List<Orders> orders= new ArrayList<Orders>();
		String queryString1 = "from Orders";
		Query query1 = sessionFactory.openSession().createQuery(queryString1);
		orders = query1.list();
		
		for(Orders order: orders) {
			Date dateOfDelivery = new Date(order.getDateOfOrder().getTime() + (1000*60*60*24));
			//System.out.println( "order" + new Date().compareTo(order.getDateOfOrder()));
			if(dateOfDelivery.compareTo(new Date()) <= 0
					&& order.getOrderStatus().equals("Pending..") ) {
				
				order.setOrderStatus("delivered");
				updateObject(order);

		//changing the book count in books table
				List<OrderHistory> orderHistoryList = new ArrayList<OrderHistory>();
				orderHistoryList = viewMyOrders(order.getCustomer().getCustId());

				int len = orderHistoryList.size();
				for(int i = 0;i < len;i++){

					Books book = new Books();
					book = orderHistoryList.get(i).getBooks();

					book.setQuantityAdded(book.getQuantityAdded()- orderHistoryList.get(i).getQuantity());
					System.out.println(orderHistoryList.get(i).getQuantity());
					if(book.getQuantityAdded() == orderHistoryList.get(i).getQuantity()){
						
						deleteObject(Books.class, book.getBookId());
					} else {
						//updateObject(book);
						sessionFactory.getCurrentSession().saveOrUpdate(book);
					}
				}
			}
		}
	}
	public static void changeBookCount(int bookId, int count) {
		Books book = new Books();
		book = getBookById(bookId);
		book.setQuantityAdded(book.getQuantityAdded()-count);
		updateObject(book);
	}

	
	private static List<OrderHistory> viewMyOrdersUsingOrderId(int orderId) {
		String queryString1 = "from OrderHistory where orderId in(select orderId from Orders where orderId =:orderId)";
		Query query1 = sessionFactory.openSession().createQuery(queryString1).setParameter("orderId", orderId);
		List<OrderHistory> orderHistory = new ArrayList<OrderHistory>();
		orderHistory = query1.list();
		return orderHistory;
	}
	
	public static List<Reviews> viewReviewsByBookId(int bookId){
		String queryString1 = "from Reviews where bookId = :bookId";
		Query query1 = sessionFactory.openSession().createQuery(queryString1).setParameter("bookId", bookId);
		List<Reviews> reviews = new ArrayList<Reviews>();
		reviews = query1.list();
		return reviews;
	}
			
	public static List<String> getAllLoginIds() {
		String queryString1 = "select loginId from Customer";
		Query query1 = sessionFactory.openSession().createQuery(queryString1);
		List<String> loginIds = new ArrayList<String>();
		loginIds = query1.list();
		return loginIds;
	}
	
	public static List<OrderHistory> getMyWallet(int custId)
	{
		double walletAmount = 0;
		List<OrderHistory> orderhist = new ArrayList<OrderHistory>();
		List<OrderHistory> orderhist1 = new ArrayList<OrderHistory>();
		String queryS="from OrderHistory";
		Query query1 = sessionFactory.openSession().createQuery(queryS);
		orderhist = query1.list();
		for(OrderHistory order:orderhist){
			System.out.println(order.getBooks());
			
			if( (order.getBooks().getCustomer() != null)  && order.getBooks().getCustomer().getCustId() == custId ){
				walletAmount += (order.getQuantity() * order.getBooks().getPrice());
				orderhist1.add(order);
			}
		
		}
		
		return orderhist1;
		
	}
	public static double getMyWallet1(int custId)
	{
		double walletAmount = 0;
		List<OrderHistory> orderhist = new ArrayList<OrderHistory>();
		List<OrderHistory> orderhist1 = new ArrayList<OrderHistory>();
		String queryS="from OrderHistory";
		Query query1 = sessionFactory.openSession().createQuery(queryS);
		orderhist = query1.list();
		for(OrderHistory order:orderhist){
			System.out.println(order.getBooks());
			
			if( (order.getBooks().getCustomer() != null)  && (order.getBooks().getCustomer().getCustId() == custId) && (order.getOrders().getOrderStatus().equals("delivered")) ){
				walletAmount += (order.getQuantity() * order.getBooks().getPrice());
				
			}
		
		}
		
		return walletAmount;
		
	}
	
	
	
	public static Customer getCustId(int ordeId) {
		String queryString1 = "select custId from Order where orderId :=orderId";
	
		return (Customer) sessionFactory.openSession().createQuery(queryString1);
		
	}
	
	



}	
			
			
			
			
			
			
			
			
			
			
	 // end



		


















/*public static Object getObjectByUserPass(String loginId,String password) {

String queryString = "from Employee where email = :loginId and password =:password";
  Query query = sessionFactory.openSession().createQuery(queryString);
  query.setString("loginId", loginId);
  query.setString("password", password);
  Object queryResult = query.uniqueResult();
  Employee employee = (Employee)queryResult;
  return employee; 
}

	
	public static Object getObject(Class c,Serializable serializable)
	{
		Object obj=null;	
		try {			
			return sessionFactory.openSession().get(c,serializable);			
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		return obj;
	}  
	
	   
	public static Object getObjectByEmail(String email) {
		
		String queryString = "from customer where email = :email";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("email", email);
		  Object queryResult = query.uniqueResult();
		  Customer customer = (Customer)queryResult;
		  return customer; 
	}
	public static Object getObjectByLoginId(String loginId) {
		
		  String queryString = "from customer where loginId = :loginId";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("loginId", loginId);
		  Object queryResult = query.uniqueResult();
		  Customer customer = (Customer)queryResult;
		  return customer; 
	}
	
	
	public static List<Object> getObjectListByName(Class c, String columName, String value) {
		Session session=sessionFactory.openSession();
		  Criteria criteria = session.createCriteria(c);
			Criterion nameCriterion = Restrictions.eq(columName, value);
			criteria.add(nameCriterion);
			return criteria.list();
	}
		*/

