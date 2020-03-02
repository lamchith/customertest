package com.infy.test.customer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.test.customer.Constants;
import com.infy.test.customer.domain.Customer;
import com.infy.test.customer.domain.CustomerAddress;
import com.infy.test.customer.exception.HistroricAddressMaxException;
import com.infy.test.customer.exception.NoCustomerFoundException;
import com.infy.test.customer.repository.CustomerRepository;
import com.infy.test.customer.rest.model.AddressInfo;
import com.infy.test.customer.rest.model.CustomerInfo;
import com.infy.test.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{


	@Autowired
	CustomerRepository customerRepository;

	@Override
	public CustomerInfo retrieveCustomer(String id) {

		Optional<Customer> cust= customerRepository.findById(id);
		Customer custDomain=null;
		if(cust.isPresent())
		{
			custDomain=cust.get();

			return constructCustomer(custDomain);
		}



		else return null;
	}

	private CustomerInfo constructCustomer(Customer custDomain) {

		CustomerInfo customerInfo= new CustomerInfo();

		customerInfo.setName(custDomain.getName());
		customerInfo.setDate(custDomain.getDate());
		customerInfo.setEmail(custDomain.getEmail());

		customerInfo.setGender(custDomain.getGender());
		customerInfo.setMobileNumber(custDomain.getMobileNumber());

		return customerInfo;
	}

	@Override
	public void createCustomer(CustomerInfo customerInfo) {

		Customer customer= new Customer();

		customer.setName(customerInfo.getName());
		customer.setDate(customerInfo.getDate());
		customer.setEmail(customerInfo.getEmail());

		customer.setGender(customerInfo.getGender());
		customer.setMobileNumber(customerInfo.getMobileNumber());

		customerRepository.save(customer);

	}

	@Override
	public void updateCustomer(String customerId,CustomerInfo customerInfo) throws NoCustomerFoundException {
		Optional<Customer> cust= customerRepository.findById(customerId);
		Customer custDomain=null;
		if(cust.isPresent())
		{
			custDomain=cust.get();
			custDomain.setDate(customerInfo.getDate());
			custDomain.setEmail(customerInfo.getEmail());
			custDomain.setGender(customerInfo.getGender());
			custDomain.setName(customerInfo.getName());
			custDomain.setMobileNumber(customerInfo.getMobileNumber());

			customerRepository.save(custDomain);
		}
		else {
			throw new NoCustomerFoundException(Constants.NO_CUSTOMER_FOUND+customerId);
		}

	}

	@Override
	public CustomerAddress retrieveCustomerAddess(String id) {
		Optional<Customer> cust= customerRepository.findById(id);
		Customer custDomain=null;
		if(cust.isPresent())
		{
			custDomain=cust.get();

			return custDomain.getActiveAddress();



		}

		return null;
	}

	@Override
	public void createCustomerAddress(String customerId, CustomerAddress address) throws HistroricAddressMaxException, NoCustomerFoundException {

		Optional<Customer> cust= customerRepository.findById(customerId);
		Customer custDomain=null;
		if(cust.isPresent())
		{
			custDomain=cust.get();


			CustomerAddress oldAddress=custDomain.getActiveAddress();

			List<CustomerAddress>historicAddress=custDomain.getHistoricAddresses();

			if(historicAddress.size()==Constants.HISTORIC_ADDRESS_SIZE) {

				throw new HistroricAddressMaxException(Constants.HISTORIC_ADDRESS_SIZE_MESSAGE);
			}

			historicAddress.add(oldAddress);
			custDomain.setActiveAddress(address);

			customerRepository.save(custDomain);

		}
		else {
			throw new NoCustomerFoundException(Constants.NO_CUSTOMER_FOUND+customerId);
		}

	}

	@Override
	public void updateCustomerAddress(String customerId, CustomerAddress address)
			throws HistroricAddressMaxException, NoCustomerFoundException {
		Optional<Customer> cust= customerRepository.findById(customerId);
		Customer custDomain=null;
		if(cust.isPresent())
		{
			custDomain=cust.get();


			CustomerAddress oldAddress=custDomain.getActiveAddress();

			List<CustomerAddress>historicAddress=custDomain.getHistoricAddresses();

			if(historicAddress.size()==Constants.HISTORIC_ADDRESS_SIZE) {

				throw new HistroricAddressMaxException(Constants.HISTORIC_ADDRESS_SIZE_MESSAGE);
			}

			historicAddress.add(oldAddress);
			custDomain.setActiveAddress(address);

			customerRepository.save(custDomain);

		}
		else {
			throw new NoCustomerFoundException(Constants.NO_CUSTOMER_FOUND+customerId);
		}


	}


}
