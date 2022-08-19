package com.aaa.capstone.enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long address_id;
	
	@Column(name = "street", unique = true, length = 45)
	private String Street;
	
	@Column(name = "unit", unique = true, length = 45)
	private int Unit;
	
	@Column(name = "city", unique = true, length = 45)
	private String City;
	
	@Column(name = "state", unique = true, length = 45)
	private String State;
	
	@Column(name = "zipcode", unique = true, length = 45)
	private String Zipcode;

	
	@OneToOne
	@JoinColumn(name = "address_id", referencedColumnName = "user_id")
	private user User;
	
	public user getUser() {
		return User;
	}

	public void setUser(user user) {
		User = user;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public int getUnit() {
		return Unit;
	}

	public void setUnit(int unit) {
		Unit = unit;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getZipcode() {
		return Zipcode;
	}

	public void setZipcode(String zipcode) {
		Zipcode = zipcode;
	}

	public Long getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Long address_id) {
		this.address_id = address_id;
	}

	

}
