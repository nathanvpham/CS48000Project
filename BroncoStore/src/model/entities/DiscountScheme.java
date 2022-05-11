package model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="discountScheme")
public class DiscountScheme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="discountId")
	private int discountId;
	
	@Column(name="discountPrice")
	private float discountPrice;
	
	/*
	@OneToMany(mappedBy="discount",
			cascade={CascadeType.PERSIST})
	private List<Student> students;
	*/
	
	@OneToMany(mappedBy="discount",
			cascade={CascadeType.PERSIST})
	private List<Professor> professor;
	
	public DiscountScheme() {
		
	}
	
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
