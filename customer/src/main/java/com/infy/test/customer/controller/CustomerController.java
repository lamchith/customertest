package com.infy.test.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.infy.test.customer.Constants;
import com.infy.test.customer.exception.NoCustomerFoundException;
import com.infy.test.customer.rest.model.CustomerInfo;
import com.infy.test.customer.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService custService;
	
	
	@GetMapping(value = Constants.CUSTOMER_URI)           
	public ResponseEntity<CustomerInfo> retrieveCustomer(@PathVariable("id") String customerId) throws Exception {
		
		ResponseEntity<CustomerInfo> resp=null;
		CustomerInfo customer;
		try {
			
			customer=custService.retrieveCustomer(customerId);
			
		}
		catch(Exception ex) {
			
			return resp;
			
		}
		
		return ResponseEntity.ok().body(customer);
		
	}
	
	@PostMapping(value = Constants.CUSTOMER_URI_POST)           
	public ResponseEntity<String> createCustomer(@RequestBody  CustomerInfo customer) throws Exception {
		
		ResponseEntity<String> resp=null;
		try {
			
			custService.createCustomer(customer);
		}
		catch(Exception ex) {
			
			return resp;
		}
		
		return ResponseEntity.ok().body(Constants.CUSTOMER_CREATED_MESSAGE);
		
	}
	
	@PutMapping(value = Constants.CUSTOMER_URI)           
	public ResponseEntity<String> updateCustomer(@PathVariable("id") String customerId,@RequestBody  CustomerInfo customer) throws Exception {
		
		ResponseEntity<String> resp=null;
		try {
			
			custService.updateCustomer(customerId,customer);
		}
		catch(NoCustomerFoundException ex) {
			
			return ResponseEntity.unprocessableEntity().body(Constants.NO_CUSTOMER_FOUND+ customerId);
			
		}
		catch(Exception ex) {
			
			return resp;
		}
		
		return ResponseEntity.ok().body(Constants.CUSTOMER_UPDATED_MESSAGE);
		
	}
}
