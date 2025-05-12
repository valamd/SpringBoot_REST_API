// CustomerService.java
package com.CakeShop.OrderSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CakeShop.OrderSystem.Entity.Customer;
import com.CakeShop.OrderSystem.Repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customer.setEmail(updatedCustomer.getEmail());
            customer.setPassword(updatedCustomer.getPassword());
            customer.setUsername(updatedCustomer.getUsername());
            return customerRepository.save(customer);
        }
        return null; // Or throw an exception indicating customer not found
    }

    @Transactional(readOnly = true)
    public Customer getCustomerById(int id) {
        return customerRepository.findById((long) id).orElse(null);
    }

}
