package com.rest1.dto;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String state;
	private String street;
	private String city;
	private String houseNo;
	private int pincode;
	public Address() {
		
	}
	public Address(String state, String street, String city, String houseNo, int pincode) {
		super();
		this.state = state;
		this.street = street;
		this.city = city;
		this.houseNo = houseNo;
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [state=" + state + ", street=" + street + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public Address(int pincode) {
		super();
		this.pincode = pincode;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	
}
