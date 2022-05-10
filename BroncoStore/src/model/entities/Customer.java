package model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Customer {
	
	@Id
	@Column(name = "broncoId")
	private int broncoId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "phone")
	private int phone;
	
	@Column(name = "dob")
	private String dateOfBirth;
	
	@Column(name = "zipCode")
	private int zipCode;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "addressNumber")
	private int addressNumber;
	
	@Column(name = "street")
	private String street;
	
	@OneToMany(mappedBy="customer",
			cascade= {CascadeType.PERSIST})
	private List<Order> orders;
	
	public Customer(int id, String name, int phone, String dateOfBirth, int addressNumber,
			String street, int zipCode, String city, String state ) {
		this.broncoId = id;
		this.name = name;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
		this.addressNumber = addressNumber;
		this.street = street;
		this.city = city;		
		this.zipCode = zipCode;
		this.state = state;

	}
	
	public void setBroncoId(int id) {
		this.broncoId = id;
	}
	
	public void setName(String name) {
		this.name= name;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public void setDateOfBirth(String dob) {
		dateOfBirth= dob;
	}
	public void setAddressNumber(int num) {
		addressNumber = num;
	}
	public void setCity(String cit) {
		city = cit;
	}
	public void setZipCode(int zip) {
		zipCode = zip;
	}
	public void setState(String sta) {
		state = sta;
	}
	public int getBroncoId() {
		return broncoId;
	}
	public String getName() {
		return name;
	}
	public int phone() {
		return phone;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public int getAddressNumber() {
		return addressNumber;
	}
	public String getCity() {
		return city;
	}
	public int getZipCode() {
		return zipCode;
	}
	public String getState() {
		return state;
	}


}
