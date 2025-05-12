// OrderService.java
package com.CakeShop.OrderSystem.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CakeShop.OrderSystem.Entity.Order;
import com.CakeShop.OrderSystem.Repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Transactional // Ensure that the transaction is active
    public Order getOrderByIdWithCakes(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            // Initialize the cakes collection
            order.getCakes().size();
        }
        return order;
    }
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }
}
