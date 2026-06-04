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
cat > ~/Downloads/cloudstore/src/main/java/com/example/cloudstore/repository/OrderRepository.java << 'EOF'
package com.example.cloudstore.repository;

import com.example.cloudstore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
