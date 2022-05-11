package model.dataccess;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.entities.*;

public class CrudCalls {
	
	
	public List<Product> getListOfProducts(){
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Customer.class).
             	addAnnotatedClass(Student.class).
             	addAnnotatedClass(Professor.class).
             	addAnnotatedClass(DiscountScheme.class).
             	addAnnotatedClass(Order.class).
             	addAnnotatedClass(Product.class).
             	addAnnotatedClass(HistoricalPrice.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Product> products = session.createQuery("from product").getResultList();
		
		session.getTransaction().commit();

		sessionFactory.close();
		
		return products;

	}
	
	public List<Order> getListOfOrders(){
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Customer.class).
             	addAnnotatedClass(Student.class).
             	addAnnotatedClass(Professor.class).
             	addAnnotatedClass(DiscountScheme.class).
             	addAnnotatedClass(Order.class).
             	addAnnotatedClass(Product.class).
             	addAnnotatedClass(HistoricalPrice.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		List<Order> orders = session.createQuery("from orders").getResultList();
		
		session.getTransaction().commit();
		
		sessionFactory.close();
		
		return orders;
	}
	
	public Customer findCustomerInfo(String name) {
		Customer customer = new Customer(0, name, 0, null, 0, null, 0, null, null);
		String hql = "from Customer s where s.name=:name";
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Customer.class).
             	addAnnotatedClass(Student.class).
             	addAnnotatedClass(Professor.class).
             	addAnnotatedClass(DiscountScheme.class).
             	addAnnotatedClass(Order.class).
             	addAnnotatedClass(Product.class).
             	addAnnotatedClass(HistoricalPrice.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		List<Customer> result = session.createQuery(hql).setParameter("name", customer.getName()).list();
		
		session.getTransaction().commit();

		return result.get(0);
		
		}
	
	public Product findProducts(String name) {
		Product products = new Product(name);
		String hql = "from Product s where s.name=:name";
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Customer.class).
             	addAnnotatedClass(Student.class).
             	addAnnotatedClass(Professor.class).
             	addAnnotatedClass(DiscountScheme.class).
             	addAnnotatedClass(Order.class).
             	addAnnotatedClass(Product.class).
             	addAnnotatedClass(HistoricalPrice.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		List<Product> result = session.createQuery(hql).setParameter("name", products.getName()).list();
		
		sessionFactory.close();
		return result.get(0);
		
	}
	
	public void deleteProduct(Product product) {	
		
		int productId = product.getProductID();
				
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Customer.class).
             	addAnnotatedClass(Student.class).
             	addAnnotatedClass(Professor.class).
             	addAnnotatedClass(DiscountScheme.class).
             	addAnnotatedClass(Order.class).
             	addAnnotatedClass(Product.class).
             	addAnnotatedClass(HistoricalPrice.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();

		Product prod = session.get(Product.class, productId);
		
		session.delete(prod);
		
		session.getTransaction().commit();	
		sessionFactory.close();
		
	}
		
	
	
	
}
