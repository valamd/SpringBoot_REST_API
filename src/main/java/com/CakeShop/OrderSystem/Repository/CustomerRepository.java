package com.CakeShop.OrderSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CakeShop.OrderSystem.Entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
