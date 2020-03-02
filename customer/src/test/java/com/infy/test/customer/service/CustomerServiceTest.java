package com.infy.test.customer.service;

import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import com.infy.test.customer.domain.Customer;
import com.infy.test.customer.repository.CustomerRepository;
import com.infy.test.customer.service.impl.CustomerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CustomerServiceTest {
	
	@InjectMocks
	private CustomerServiceImpl customerServiceImpl ;
	
	@Mock
	private CustomerRepository repository;
	
	Customer cust;
	
	@Before
	public void setup()
	{
		cust= new Customer();
		cust.setDate("2/3/2020");
		cust.setEmail("cust1@gmail.com");
		cust.setGender("male");
		cust.setMobileNumber("988664532");
	}
	
	
	@Test
	public void testRetrieveCustomer(){
		String id="12356";
		
		Mockito.when(repository.findById(id)).thenReturn(Optional.of(cust));
		
		customerServiceImpl.retrieveCustomer(id);
		
	}

}
