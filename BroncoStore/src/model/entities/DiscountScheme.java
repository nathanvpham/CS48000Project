package model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="discountScheme")
public class DiscountScheme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int discountId;
	
	@Column(name="disocuntPrice")
	private float discountPrice;
	
	public DiscountScheme(float price) {
		discountPrice = price;
	}
	public void setDiscount(float price) {
		discountPrice = price;
	}
	public float getDiscount() {
		return discountPrice;
	}
}
