package model.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studentId")
	private int studentId;
	
	@Column(name = "minor")
	private String minor;
	
	@Column(name = "major")
	private String major;
	
	@Column(name = "gradDate")
	private Date gradDate;
	
	@Column(name = "enterDate")
	private Date enterDate;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="broncoId")
	private Customer customer;
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="discountID")
	private DiscountScheme discount;
	
	public Student() {
		
	}

	public Student(String minor, String major, Date gradDate, 
			Date enterDate, Customer customer, DiscountScheme discount) {
		// (int id, String name, int phone, String dateOfBirth, int addressNumber, 
		// String street, int zipCode, String city, String state)
		// super(id, name, phone, dateOfBirth, addressNumber, street, zipCode, city, state);
		
		this.minor = minor;
		this.major = major;
		this.gradDate = gradDate;
		this.enterDate = enterDate;
		this.customer = customer;
		this.discount = discount;
	}
	public void setMinor(String minor) {
		this.minor = minor;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public void setGradDate(Date gradDate) {
		this.gradDate = gradDate;
	}
	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}
	public void setDiscount(DiscountScheme dis) {
		discount = dis;
	}
	
	public DiscountScheme getDiscount() {
		return discount;
	}
	public String getMinor() {
		return minor;
	}
	public String getMajor() {
		return major;
	}
	public Date getGradDate() {
		return gradDate;
	}
	public Date getEnterDate() {
		return enterDate;
	}
}


