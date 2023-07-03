package com.ahmad.springhateoas.service;

import com.ahmad.springhateoas.domain.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    public List<Order> getAllOrdersForCustomer(String customerId);
    public Order getOrderDetail(String customerId, String orderId);

}
