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
import com.infy.test.customer.domain.CustomerAddress;
import com.infy.test.customer.exception.HistroricAddressMaxException;
import com.infy.test.customer.exception.NoCustomerFoundException;
import com.infy.test.customer.rest.model.CustomerInfo;
import com.infy.test.customer.service.CustomerService;

@RestController
public class CustomerAddressController {

	@Autowired
	CustomerService custService;


	@GetMapping(value = Constants.CUSTOMER_ADDRESS_URI)           
	public ResponseEntity<CustomerAddress> retrieveCustomer(@PathVariable("id") String customerId) throws Exception {

		ResponseEntity<CustomerAddress> resp=null;
		CustomerAddress address;
		try {

			address=custService.retrieveCustomerAddess(customerId);

		}
		catch(Exception ex) {

			return resp;

		}

		return ResponseEntity.ok().body(address);

	}

	@PostMapping(value = Constants.CUSTOMER_ADDRESS_URI)           
	public ResponseEntity<String> createCustomer(@PathVariable("id") String customerId,@RequestBody  CustomerAddress address) throws Exception {

		ResponseEntity<String> resp=null;
		try {

			custService.createCustomerAddress(customerId,address);
		}

		catch(HistroricAddressMaxException ex) {

			return ResponseEntity.badRequest().body(Constants.HISTORIC_ADDRESS_SIZE_MESSAGE);
		}
		
		catch(NoCustomerFoundException ex) {

			return ResponseEntity.badRequest().body(Constants.NO_CUSTOMER_FOUND+ customerId);

		}

		catch(Exception ex) {

			return resp;
		}

		return ResponseEntity.ok().body(Constants.CUSTOMER__ADDRESS_CREATED_MESSAGE);

	}

	@PutMapping(value = Constants.CUSTOMER_ADDRESS_URI)           
	public ResponseEntity<String> updateCustomer(@PathVariable("id") String customerId,@RequestBody  CustomerAddress address) throws Exception {

		ResponseEntity<String> resp=null;
		try {

			custService.updateCustomerAddress(customerId,address);
		}
		catch(NoCustomerFoundException ex) {

			return ResponseEntity.badRequest().body(Constants.NO_CUSTOMER_FOUND+ customerId);

		}
		catch(Exception ex) {

			return resp;
		}

		return ResponseEntity.ok().body(Constants.CUSTOMER_UPDATED_MESSAGE);

	}
}
