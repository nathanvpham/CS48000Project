package model.entities;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
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
	private Date date;
	
	@Column(name="time")
	private Time time;
	
	@ManyToOne
	@JoinColumn(name="broncoId")
	Customer customer;
	
	@ManyToMany(cascade={CascadeType.PERSIST})
	@JoinTable(
			name="order_product",
			joinColumns=@JoinColumn(name="orderID"),
			inverseJoinColumns=@JoinColumn(name="productID")
			)
	private List<Product> productList;
	
	public Order() {
		
	}
	
	public Order(Date date, Time time) {
		this.date = date;
		this.time = time;
	}
	
	public void addProduct(Product product) {
		if(productList == null) {
			productList = new ArrayList<>();
		}
		productList.add(product);
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setTime(Time time) {
		this.time = time;
	}
	
	public Date getDate() {
		return date;
	}
	
	public Time getTime() {
		return time;		
	}
	
	public double calculateTotalPrice() {
		double total = 0;
		for(int i = 0; i < productList.size(); ++i) {
			total += productList.get(i).getCurrentPrice();
		}
		
		return total;
	}
	
	
}
