// CakeController.java
package com.CakeShop.OrderSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.CakeShop.OrderSystem.Entity.Cake;
import com.CakeShop.OrderSystem.Service.CakeService;

@RestController
@RequestMapping("/Cake")
public class Cakecontroller {

    @Autowired
    private CakeService cakeService;

    @GetMapping
    public List<Cake> getAllCakes() {
        return cakeService.getAllCakes();
    }

    @GetMapping("/{id}")
    public Cake getCakeById(@PathVariable Long id) {
        return cakeService.getCakeById(id);
    }

    @PostMapping
    public Cake createCake(@RequestBody Cake cake) {
        return cakeService.createCake(cake);
    }

    @DeleteMapping("/{id}")
    public void deleteCake(@PathVariable Long id) {
        cakeService.deleteCake(id);
    }

    @PutMapping("/{id}")
    public Cake updateCake(@PathVariable Long id, @RequestBody Cake cake) {
        return cakeService.updateCake(id, cake);
    }
}
