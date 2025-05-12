package com.CakeShop.OrderSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CakeShop.OrderSystem.Entity.Customer;
import com.CakeShop.OrderSystem.Entity.Order;
import com.CakeShop.OrderSystem.Service.CustomerService;
import com.CakeShop.OrderSystem.Service.OrderService;

@RestController
@RequestMapping("Order")
public class Ordercontroller {
	@Autowired
    private OrderService orderService;
	CustomerService customerservice;
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        Customer customer = order.getCustomer();
        if (customer == null) {
            // Initialize the customer field if it is null
            customer = new Customer();
            order.setCustomer(customer);
        }

        return orderService.createOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        order.setId(id); 
        // Set the customer ID instead of the entire customer object
        order.getCustomer().setId(order.getCustomer().getId());
        order.setOrderDateTime(order.getOrderDateTime());
        order.setTotalPrice(order.getTotalPrice());
        order.setCakes(order.getCakes());
        return orderService.updateOrder(order);
    }

}
