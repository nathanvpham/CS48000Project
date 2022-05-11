package model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@Column(name = "id")
	private int broncoId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "phone")
	private int phone;
	
	@Column(name = "dateOfBirth")
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
	

	
	public Customer(String name, int phone, String dateOfBirth, int addressNumber,
			String street, int zipCode, String city, String state ) {
		this.name = name;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
		this.addressNumber = addressNumber;
		this.street = street;
		this.city = city;		
		this.zipCode = zipCode;
		this.state = state;

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
