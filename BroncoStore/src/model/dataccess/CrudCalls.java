package model.dataccess;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.entities.Customer;
import model.entities.DiscountScheme;
import model.entities.HistoricalPrice;
import model.entities.Order;
import model.entities.Product;
import model.entities.Professor;
import model.entities.Student;

public class CrudCalls {
	
	
	public List<Product> getListOfProducts(){
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Product.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<Product> products = session.createQuery("from product").getResultList();
		
		session.getTransaction().commit();

		sessionFactory.close();
		
		return products;

	}
	
	public List<Order> getListOfOrders(){
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Order.class).buildSessionFactory();
		
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
				addAnnotatedClass(Customer.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		List<Student> result = session.createQuery(hql).setParameter("name", customer.getName()).list();
		
		session.getTransaction().commit();

		return result.get(0);
		
		}
	public Customer findProducts(String name) {
		Product products = new Product(name);
		String hql = "from Product s where s.name=:name";
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Product.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		List<Student> result = session.createQuery(hql).setParameter("name", Product.getName()).list();
		
		sessionFactory.close();
		return result.get(0);
		
	}
	
	public void deleteProduct(Product product) {	
		
		int productId = product.getId();
				
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Product.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();

		Product prod = session.get(Product.class, productId);
		
		session.delete(prod);
		
		session.getTransaction().commit();	
		sessionFactory.close();
		
	}
		
	
	
	
}
