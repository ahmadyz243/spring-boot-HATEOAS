package com.ahmad.springhateoas.controller.rest;

import com.ahmad.springhateoas.domain.Customer;
import com.ahmad.springhateoas.domain.Order;
import com.ahmad.springhateoas.service.CustomerService;
import com.ahmad.springhateoas.service.OrderService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
    public CustomerController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    private final CustomerService customerService;
    private final OrderService orderService;



    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable String customerId) {

        Customer customer = customerService.getCustomerDetail(customerId);
        //Link link = Link.of("http://localhost:8080/spring-security-rest/api/customers/10A");
        Link link = linkTo(CustomerController.class).slash(customer.getCustomerId()).withSelfRel();
        customer.add(link);
        return customer;

    }

    @GetMapping("/{customerId}/{orderId}")
    public Order getOrderById(@PathVariable String customerId, @PathVariable String orderId) {

        Order order = orderService.getOrderDetail(customerId, orderId);
        //Link link = Link.of("http://localhost:8080/spring-security-rest/api/customers/10A");
        Link link = linkTo(CustomerController.class).slash(order.getOrderId()).withSelfRel();
        order.add(link);
        return order;

    }

    @GetMapping(value = "/{customerId}/orders", produces = { "application/hal+json" })
    public CollectionModel<Order> getOrdersForCustomer(@PathVariable final String customerId) {

        List<Order> orders = orderService.getAllOrdersForCustomer(customerId);
        for (final Order order : orders) {
            Link selfLink = linkTo(methodOn(CustomerController.class).getOrderById(customerId, order.getOrderId())).withSelfRel();
            order.add(selfLink);
        }

        Link link = linkTo(methodOn(CustomerController.class).getOrdersForCustomer(customerId)).withSelfRel();
        CollectionModel<Order> result = CollectionModel.of(orders, link);
        return result;

    }

    @GetMapping(value = "/allCustomers", produces = { "application/hal+json" })
    public CollectionModel<Customer> getAllCustomers() {
        List<Customer> allCustomers = customerService.allCustomers();

        for (Customer customer : allCustomers) {
            String customerId = customer.getCustomerId();
            Link selfLink = linkTo(CustomerController.class).slash(customerId).withSelfRel();
            customer.add(selfLink);
            if (orderService.getAllOrdersForCustomer(customerId).size() > 0) {
                Link ordersLink = linkTo(methodOn(CustomerController.class).getOrdersForCustomer(customerId)).withRel("allOrders");
                customer.add(ordersLink);
            }
        }

        Link link = linkTo(CustomerController.class).withSelfRel();
        return CollectionModel.of(allCustomers, link);
    }

}
