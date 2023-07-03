package com.ahmad.springhateoas.domain;

import org.springframework.hateoas.RepresentationModel;

import java.util.ArrayList;
import java.util.List;

public class Customer extends RepresentationModel<Customer> {

    public Customer() {
    }

    public Customer(String customerId, String customerName, String companyName, List<Order> orders){
        this.customerId = customerId;
        this.customerName = customerName;
        this.companyName = companyName;
        this.orders = orders;
    }

    private String customerId;
    private String customerName;
    private String companyName;
    private List<Order> orders = new ArrayList<>();


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
