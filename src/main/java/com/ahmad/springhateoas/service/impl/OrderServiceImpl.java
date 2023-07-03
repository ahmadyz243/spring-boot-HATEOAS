package com.ahmad.springhateoas.service.impl;

import com.ahmad.springhateoas.domain.Order;
import com.ahmad.springhateoas.repository.OrderRepository;
import com.ahmad.springhateoas.service.OrderService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {
    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    private final OrderRepository repository;



    @Override
    public List<Order> getAllOrdersForCustomer(String customerId) {
        return repository.findAllByCustomerId(customerId);
    }

    @Override
    public Order getOrderDetail(String customerId, String orderId) {
        return repository.findByCustomerIdAndOrderId(customerId, orderId);
    }
}
