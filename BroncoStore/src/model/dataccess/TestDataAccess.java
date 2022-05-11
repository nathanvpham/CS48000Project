package model.dataccess;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Scanner;

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

public class TestDataAccess {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().
             	configure("hibernate.cfg.xml").
             	addAnnotatedClass(Customer.class).
             	addAnnotatedClass(Student.class).
             	addAnnotatedClass(Professor.class).
             	addAnnotatedClass(DiscountScheme.class).
             	addAnnotatedClass(Order.class).
             	addAnnotatedClass(Product.class).
             	addAnnotatedClass(HistoricalPrice.class).
             	buildSessionFactory();
				
		Scanner sc = new Scanner(System.in);
		
		boolean done = false;
		
		while (!done) {
			System.out.print("\nTests:\n"
					+ "1 - create a student customer\n"
					+ "2 - create a professor customer\n"
					+ "3 - create a product\n"
					+ "4 - test customer and order relationship\n"
					+ "5 - test order and product relationship\n"
					+ "q - quit\n"
					+ "Enter: ");
			
			char testcase = sc.nextLine().charAt(0);
			
			switch (testcase) {
				case '1':
					testCreateStudent(factory.getCurrentSession());
					break;
				case '2':
					testCreateProfessor(factory.getCurrentSession());
					break;
				case '3':
					testCreateProduct(factory.getCurrentSession());
					break;
				case '4':
					testCustomerOrder(factory.getCurrentSession());
					break;
				case '5':
					testOrderProduct(factory.getCurrentSession());
					break;
				case 'q':
					done = true;
				default:
					;
			}
			
		}
		
		factory.close();
		sc.close();
		
	}
	
	public static void testCreateStudent(Session session) {
		
		System.out.println("Creating student customer...");
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			
			session.beginTransaction();

			DiscountScheme discount = new DiscountScheme(0);
			
			// Customer customer = session.get(Customer.class, 1);
			Customer customer = new Customer(1, "", 0, "", 0, "", 0, "", "");
			
			Student student = new Student("", "", formatter.parse("10/05/2022"),
					formatter.parse("10/05/2022"), customer, discount);
			
			session.save(discount);
			session.save(student);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Finished!");
	
	}

	public static void testCreateProfessor(Session session) {
		
		System.out.println("Creating professor customer...");
				
		try {
			
			session.beginTransaction();
			
			DiscountScheme discount = new DiscountScheme(0);
			
			// Customer customer = session.get(Customer.class, 2);
			Customer customer = new Customer(2, "", 0, "", 0, "", 0, "", "");
			
			Professor professor = new Professor("", "", "", customer, discount);
															
			session.save(discount);
			session.save(professor);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Finished!");
	
	}
	
	public static void testCreateProduct(Session session) {
		
		System.out.println("Creating product with price history...");
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				
		try {
			HistoricalPrice price = new HistoricalPrice(formatter.parse("10/05/2022"), 0);
			
			Product product = new Product("");
			
			product.addHistPrice(price);
												
			session.beginTransaction();
			
			session.save(product);
			session.save(price);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Finished!");
	
	}
	
public static void testCustomerOrder(Session session) {
		
		System.out.println("Creating customer with order...");
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			
			session.beginTransaction();
			
			Order order1 = new Order(formatter.parse("10/05/2022"), Time.valueOf("12:00:00"));
			Order order2 = new Order(formatter.parse("10/05/2022"), Time.valueOf("12:00:00"));
			
			Customer customer = session.get(Customer.class, 1);
			
			customer.addOrder(order1);
			customer.addOrder(order2);
			
			// session.save(customer);
			session.save(order1);
			session.save(order2);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Finished!");
	
	}
	
	public static void testOrderProduct(Session session) {
		
		System.out.println("Creating order with product...");
						
		try {
			
			session.beginTransaction();
			
			Product product = session.get(Product.class, 1);
			
			Order order1 = session.get(Order.class, 1);
			Order order2 = session.get(Order.class, 2);
			
			order1.addProduct(product);
			order2.addProduct(product);
			
			session.save(order1);
			session.save(order2);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Finished!");
	
	}
	
}
