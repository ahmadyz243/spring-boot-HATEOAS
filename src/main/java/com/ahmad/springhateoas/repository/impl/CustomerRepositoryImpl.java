package com.ahmad.springhateoas.repository.impl;

import com.ahmad.springhateoas.domain.Customer;
import com.ahmad.springhateoas.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CustomerRepositoryImpl implements CustomerRepository {

    private final List<Customer> allCustomers = Arrays.asList(
            new Customer("1", "Ali", "AAA", new ArrayList<>())
            , new Customer("2", "Bahram", "BBB", new ArrayList<>())
            , new Customer("3", "Cina", "CCC", new ArrayList<>())
            , new Customer("4", "David", "DDD", new ArrayList<>())
            , new Customer("5", "Ehsan", "EEE", new ArrayList<>())
    );

    @Override
    public Customer findById(String customerId) {

        for(Customer customer: allCustomers){
            if (customer.getCustomerId().equals(customerId)){
                return customer;
            }
        }

        return null;

    }

    @Override
    public List<Customer> findAll() {
        return allCustomers;
    }

}
