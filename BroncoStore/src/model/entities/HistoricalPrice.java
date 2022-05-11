package model.entities;

import java.util.Date;

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
	@Column(name="historicalPriceId")
	private int historicalPriceId;

	@Column(name="priceDate")
	private Date priceDate;
	
	@Column(name="price")
	private double price;
	
	@ManyToOne
	@JoinColumn(name="productID")
	private Product product;
	
	public HistoricalPrice() {
		
	}
	
	public HistoricalPrice(Date priceDate, double price) {
		this.priceDate = priceDate;
		this.price = price;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void SetPriceDate(Date date) {
		priceDate = date;
	}
	
	public double getPrice() {
		return price;
	}
	
	public Date getPriceDate() {
		return priceDate;
	}
}
