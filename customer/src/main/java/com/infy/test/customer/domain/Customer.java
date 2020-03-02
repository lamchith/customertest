package com.infy.test.customer.domain;


import com.couchbase.client.java.repository.annotation.Field;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import java.util.List;

import org.springframework.data.annotation.Id;

@Document
public class Customer {
	
	@Field("name")
	private String name;
	
	@Field("date")
	private String date;
	
	@Field("gender")
	private String gender;
	
	@Field("email")
	private String email;
	
	@Field("mobileNumber")
	private String mobileNumber;
	
    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private String id;
    
    @Field("activeAddress")
    private CustomerAddress activeAddress;
    
    @Field("historicAddresses")
    private List<CustomerAddress> historicAddresses;
	
	
	
	
	public CustomerAddress getActiveAddress() {
		return activeAddress;
	}
	public void setActiveAddress(CustomerAddress activeAddress) {
		this.activeAddress = activeAddress;
	}
	public List<CustomerAddress> getHistoricAddresses() {
		return historicAddresses;
	}
	public void setHistoricAddresses(List<CustomerAddress> historicAddresses) {
		this.historicAddresses = historicAddresses;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
	
	
	

}
