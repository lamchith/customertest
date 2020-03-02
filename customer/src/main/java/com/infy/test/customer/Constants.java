package com.infy.test.customer;

public class Constants {

	public static final String CUSTOMER_URI = "/customer/{id}";
	public static final String CUSTOMER_URI_POST = "/customer";
	
	public static final String CUSTOMER_CREATED_MESSAGE = "customer created successfully";
	public static final String NO_CUSTOMER_FOUND = "No customer found for the customerID : ";

	public static final String CUSTOMER_UPDATED_MESSAGE = "customer updated successfully";
	
	public static final String CUSTOMER_ADDRESS_URI = "/customer/{id}/address";
	
	public static final int HISTORIC_ADDRESS_SIZE = 5;
	
	public static final String HISTORIC_ADDRESS_SIZE_MESSAGE = "Maximum allowed adress changes is 5";
	public static final String CUSTOMER__ADDRESS_CREATED_MESSAGE = "customer created successfully";
}
