package com.ahmad.springhateoas.repository.impl;

import com.ahmad.springhateoas.domain.Order;
import com.ahmad.springhateoas.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class OrderRepositoryImpl implements OrderRepository {

    private final List<Order> allOrders = Arrays.asList(
            new Order("1", 120000, 10, "1")
            ,new Order("2", 140000, 12, "1")
            ,new Order("3", 133000, 6, "2")
            ,new Order("4", 75000, 22, "3")
            ,new Order("5", 86500, 15, "3")
    );


    @Override
    public List<Order> findAllByCustomerId(String customerId) {

        List<Order> orders = new ArrayList<>();
        for(Order order: allOrders){
            if (order.getCustomerId().equals(customerId)){
                orders.add(order);
            }
        }
        return orders;

    }

    @Override
    public Order findByCustomerIdAndOrderId(String customerId, String orderId) {

        for (Order order: allOrders) {
            if (order.getOrderId().equals(orderId) && order.getCustomerId().equals(customerId)){
                return order;
            }
        }
        return null;

    }
}
