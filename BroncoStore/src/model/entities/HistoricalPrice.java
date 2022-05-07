package model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="historicalPrice")
public class HistoricalPrice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="priceDate")
	private String priceDate;
	
	@Column(name="price")
	private double price;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	public HistoricalPrice(String priceDate, double price) {
		this.priceDate = priceDate;
		this.price = price;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void SetPriceDate(String date) {
		priceDate = date;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getPriceDate() {
		return priceDate;
	}
}
