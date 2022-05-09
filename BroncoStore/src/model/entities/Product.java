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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="productId")
	private int productId;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany(cascade={CascadeType.PERSIST})
	@JoinTable(
			name="orders_product",
			joinColumns=@JoinColumn(name="productId"),
			inverseJoinColumns=@JoinColumn(name="orderID")
			)
	private List<Order> ordersList;
	
	@OneToMany(mappedBy="product",
			cascade = {CascadeType.PERSIST})
	private List<HistoricalPrice> prices;
	
	public Product(String name) {
		this.name = name;
	}
	
	public void add(HistoricalPrice price) {
		if(prices == null) {
			prices = new ArrayList<>();
		}
		prices.add(price);
		
		price.setProduct(this);
	}

}
