package com.CakeShop.OrderSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CakeShop.OrderSystem.Entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
