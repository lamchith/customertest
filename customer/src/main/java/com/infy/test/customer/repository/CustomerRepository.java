package com.infy.test.customer.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infy.test.customer.domain.Customer;

@Repository
public interface  CustomerRepository  extends  CrudRepository<Customer, String> {
	
	List<Customer> findById();

}
