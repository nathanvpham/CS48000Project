package model.dataccess;

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
		
		Session session = factory.getCurrentSession();
		
		Scanner sc = new Scanner(System.in);
		
		boolean done = false;
		
		while (!done) {
			System.out.print("\nTests:\n"
					+ "1 - create a student customer\n"
					+ "q - quit\n"
					+ "Enter: ");
			
			char testcase = sc.nextLine().charAt(0);
			
			switch (testcase) {
				case '1':
					testCreateStudent(session);
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
		
		try {
			DiscountScheme discount = new DiscountScheme(0);
			
			Student customer = new Student(0, "", 0, "", 0, "", 0, "", "", "", "", "", "", discount);
												
			session.beginTransaction();
			
			session.save(customer);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Finished!");
	
	}

}
