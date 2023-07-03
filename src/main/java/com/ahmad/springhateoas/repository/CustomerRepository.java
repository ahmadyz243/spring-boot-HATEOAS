package com.ahmad.springhateoas.repository;

import com.ahmad.springhateoas.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository {

    Customer findById(String customerId);
    List<Customer> findAll();

}
