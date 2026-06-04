package com.example.cloudstore.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String productTitle;
    private Double productPrice;
    private LocalDateTime orderDate;

    public Order() {}

    public Order(String username, String productTitle, Double productPrice) {
        this.username = username;
        this.productTitle = productTitle;
        this.productPrice = productPrice;
        this.orderDate = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getProductTitle() { return productTitle; }
    public Double getProductPrice() { return productPrice; }
    public LocalDateTime getOrderDate() { return orderDate; }
}