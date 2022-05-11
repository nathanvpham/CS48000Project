package model.entities;

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
@Table(name="professor")
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "professorId")
	private int professorId;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "research")
	private String research;
	
	@Column(name = "office")
	private String office;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="broncoId")
	private Customer customer;
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="discountID")
	private DiscountScheme discount;
	
	public Professor() {
		
	}

	public Professor(String department, String research,
			String office, Customer customer, DiscountScheme discount) {
		// int id, String name, int phone, String dateOfBirth, int addressNumber, 
		// String street, int zipCode, String city, String state)
		// super(id, name, phone, dateOfBirth, addressNumber, street, zipCode, city, state);
		
		this.department = department;
		this.research = research;
		this.office = office;
		this.customer = customer;
		this.discount = discount;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setResearch(String research) {
		this.research = research;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public void setDiscount(DiscountScheme dis) {
		discount = dis;
	}
	public DiscountScheme getDiscount() {
		return discount;
	}
	public String getDepartment() {
		return department;
	}
	public String getResearch() {
		return research;
	}
	public String getOffice() {
		return office;
	}

}
