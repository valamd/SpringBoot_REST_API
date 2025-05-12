package com.CakeShop.OrderSystem.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
@Entity
@JsonIgnoreType
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL) // FetchType.LAZY for better performance
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany(fetch = FetchType.EAGER) // FetchType.LAZY for better performance
    @JoinTable(
            name = "order_cakes",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "cake_id")
    )
    private List<Cake> cakes;
    @Column(nullable = false)
    private LocalDateTime orderDateTime;
    @Transient
    private double totalPrice;
    @Transient
    private int customerId;
    
    // Constructors
    public Order() {
    }
    
    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Cake> getCakes() {
        return cakes;
    }

    public void setCakes(List<Cake> cakes) {
        this.cakes = cakes;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public double getTotalPrice() {
    	double temp=0;
    	for(Cake c:cakes)
    	{
    		temp += c.getPrice();
    	}
    	totalPrice = temp;
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    @Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", cakes=" + cakes + ", orderDateTime=" + orderDateTime
				+ ", totalPrice=" + totalPrice + ", customerId=" + customerId + "]";
	}

	public Order getOrder() {
		// TODO Auto-generated method stub
		return this;
	}

	public long getCustomerId() {
		// TODO Auto-generated method stub
		return this.customer.getId();
	}
}