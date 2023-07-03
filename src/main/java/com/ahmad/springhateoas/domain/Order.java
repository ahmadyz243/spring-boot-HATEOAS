package com.ahmad.springhateoas.domain;

import org.springframework.hateoas.RepresentationModel;

public class Order extends RepresentationModel<Order> {

    public Order(){}

    public Order(String orderId, double price, int quantity, String customerId) {
        this.orderId = orderId;
        this.price = price;
        this.quantity = quantity;
        this.customerId = customerId;
    }

    private String orderId;
    private double price;
    private int quantity;
    private String customerId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
