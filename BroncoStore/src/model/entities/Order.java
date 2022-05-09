package model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orderID")
	private int orderID;
	
	@Column(name="date")
	private String date;
	
	@Column(name="time")
	private String time;
	
	@ManyToOne
	@JoinColumn(name="broncoId")
	Customer customer;
	
	@ManyToMany(cascade={CascadeType.PERSIST})
	@JoinTable(
			name="orders_products",
			joinColumns=@JoinColumn(name="order_id"),
			inverseJoinColumns=@JoinColumn(name="product_id")
			)
	private ArrayList<Product> productList;
	
	public Order(String date, String time) {
		this.date = date;
		this.time = time;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void add(Product product) {
		if(productList == null) {
			productList = new ArrayList<Product>();
		}
		productList.add(product);
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getTime() {
		return time;		
	}
	
	public double getTotalPrice() {
		double total = 0;
		for(int i = 0; i < productList.size(); ++i) {
			total += productList.get(i).getCurrentPrice();
		}
		
		return total;
	}
	
	
}
