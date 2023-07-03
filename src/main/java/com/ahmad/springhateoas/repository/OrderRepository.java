package com.ahmad.springhateoas.repository;

import com.ahmad.springhateoas.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository {

    public List<Order> findAllByCustomerId(String customerId);
    public Order findByCustomerIdAndOrderId(String customerId, String orderId);

}
