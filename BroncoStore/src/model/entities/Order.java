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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int discountId;
	
	@Column(name="date")
	private String date;
	
	@Column(name="time")
	private String time;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	Customer customer;
	
	@OneToMany(mappedBy="product", cascade = {CascadeType.PERSIST})
	@JoinColumn( name="product_id")
	private List<Product> products;
	
	public Order(String date, String time) {
		this.date = date;
		this.time = time;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void add(Product product) {
		if(products == null) {
			products = new ArrayList<>();
		}
		products.add(product);
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
	
	
}
