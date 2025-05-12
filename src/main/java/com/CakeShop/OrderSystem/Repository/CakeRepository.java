package com.CakeShop.OrderSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CakeShop.OrderSystem.Entity.Cake;
@Repository
public interface CakeRepository extends JpaRepository<Cake, Long>{
}
