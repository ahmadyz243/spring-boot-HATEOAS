package com.ahmad.springhateoas.service.impl;

import com.ahmad.springhateoas.domain.Customer;
import com.ahmad.springhateoas.repository.CustomerRepository;
import com.ahmad.springhateoas.service.CustomerService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerServiceImpl implements CustomerService {
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    private final CustomerRepository repository;


    @Override
    public Customer getCustomerDetail(String customerId) {
        return repository.findById(customerId);
    }

    @Override
    public List<Customer> allCustomers() {
        return repository.findAll();
    }

}
