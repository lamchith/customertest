package com.infy.test.customer.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.infy.test.customer.domain.CustomerAddress;
import com.infy.test.customer.exception.HistroricAddressMaxException;
import com.infy.test.customer.exception.NoCustomerFoundException;
import com.infy.test.customer.rest.model.AddressInfo;
import com.infy.test.customer.rest.model.CustomerInfo;

public interface CustomerService {
	
	CustomerInfo retrieveCustomer(String id) ;
	
	void  createCustomer(CustomerInfo customerInfo) ;

	void updateCustomer(String customerId, CustomerInfo customer) throws NoCustomerFoundException;
	
	CustomerAddress retrieveCustomerAddess(String id) ;
	
	void  createCustomerAddress(String customerId,CustomerAddress address) throws HistroricAddressMaxException, NoCustomerFoundException ;
	
	void  updateCustomerAddress(String customerId,CustomerAddress address) throws HistroricAddressMaxException,NoCustomerFoundException ;

}
