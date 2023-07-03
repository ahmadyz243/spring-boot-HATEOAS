package com.ahmad.springhateoas.service;

import com.ahmad.springhateoas.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    Customer getCustomerDetail(String customerId);
    List<Customer> allCustomers();

}
