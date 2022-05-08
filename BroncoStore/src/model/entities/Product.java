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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="product", cascade = {CascadeType.PERSIST})
	@JoinColumn( name="historicalPrice_id")
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
	
	public double getPrice(int i) {
		return prices.get(i).getPrice();
	}
	//to get the currentPrice
	public double getPrice() {
		return prices.get(0).getPrice();

	}

}
