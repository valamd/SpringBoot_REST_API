// CakeService.java
package com.CakeShop.OrderSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CakeShop.OrderSystem.Entity.Cake;
import com.CakeShop.OrderSystem.Repository.CakeRepository;

@Service
public class CakeService {

    @Autowired
    private CakeRepository cakeRepository;

    public List<Cake> getAllCakes() {
        return cakeRepository.findAll();
    }

    public Cake getCakeById(Long id) {
        return cakeRepository.findById(id).orElse(null);
    }

    public Cake createCake(Cake cake) {
        return cakeRepository.save(cake);
    }

    public void deleteCake(Long id) {
        cakeRepository.deleteById(id);
    }

    public Cake updateCake(Long id, Cake updatedCake) {
        Cake cake = cakeRepository.findById(id).orElse(null);
        if (cake != null) {
            cake.setName(updatedCake.getName());
            cake.setPrice(updatedCake.getPrice());
            cake.setDescription(updatedCake.getDescription());
            return cakeRepository.save(cake);
        }
        return null; // Or throw an exception indicating cake not found
    }
}
